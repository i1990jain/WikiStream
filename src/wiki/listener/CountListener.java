package wiki.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

@Component
public class CountListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		StringBuilder sb = new StringBuilder();

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(dateFormat.format(date.getTime()));
		for (EventBean event : newEvents) {
			sb.append("Count of Feeds : " + event.get("count"));
		}

		System.out.println(sb.toString());
	}
}