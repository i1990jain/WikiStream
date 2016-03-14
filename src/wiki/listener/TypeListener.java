package wiki.listener;

import org.springframework.stereotype.Component;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

@Component
public class TypeListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		StringBuilder sb = new StringBuilder();
		sb.append("Types of Feeds: ");
		sb.append("(");
		int count = 0;
		for (EventBean event : newEvents) {
			sb.append("(" + event.get("type") + ",");
			sb.append(event.get("count") + ")");
			count++;
			if (count != newEvents.length) {
				sb.append(",");
			}
		}
		sb.append(")");
		System.out.println(sb.toString());
	}
}