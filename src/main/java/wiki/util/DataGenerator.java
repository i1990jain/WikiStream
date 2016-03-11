package wiki.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wiki.data.Data;
import wiki.handler.StreamHandler;

/**
 * Just a simple class to create a number of Random TemperatureEvents and pass
 * them off to the TemperatureEventHandler.
 */
@Component
public class DataGenerator {

	/** Logger */
	private static Logger LOG = LoggerFactory.getLogger(DataGenerator.class);

	/**
	 * The StreamHandler - wraps the Esper engine and processes the Events
	 */
	@Autowired
	private StreamHandler streamHandler;

	/**
	 * Handles the every entry of data and sends it to the streamHandler
	 */
	public void startSendingData(final Data data) {

		ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();

		xrayExecutor.submit(new Runnable() {
			public void run() {

				streamHandler.handle(data);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					LOG.error("Thread Interrupted", e);
				}

			}
		});
	}

}
