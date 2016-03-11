package wiki.stream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;
import wiki.data.Data;
import wiki.util.DataGenerator;

public class App {

	public static void main(String[] args) throws URISyntaxException, MalformedURLException {
		// Load spring config
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });
		BeanFactory factory = (BeanFactory) appContext;

		// Start Demo
		final DataGenerator generator = (DataGenerator) factory.getBean("dataGenerator");

		final SocketIO socket = new SocketIO("http://stream.wikimedia.org/rc");
		socket.connect(new IOCallback() {
			public void onMessage(JSONObject json, IOAcknowledge ack) {
				try {
					System.out.println("Server said:" + json.toString(2));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

			public void onMessage(String data, IOAcknowledge ack) {
				System.out.println("Server said: " + data);
			}

			public void onError(SocketIOException socketIOException) {
				System.out.println("an Error occured");
				socketIOException.printStackTrace();
			}

			public void onDisconnect() {
				System.out.println("Connection terminated.");
			}

			public void onConnect() {
				System.out.println("Connection established");
				// socket.emit("subscribe", "commons.wikimedia.org");

				socket.emit("subscribe", "en.wikipedia.org");
				// socket.emit("subscribe", "it.wikipedia.org");
			}

			public void on(String event, IOAcknowledge ack, Object... args) {
				ObjectMapper mapper = new ObjectMapper();
				if (event.equals("change")) {

					for (Object obj : args) {

						try {
							Data data = mapper.readValue(obj.toString(), Data.class);
							generator.startSendingData(data);

						} catch (JsonParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		});

		// This line is cached until the connection is established.
		socket.send("Hello Server!");
	}
}