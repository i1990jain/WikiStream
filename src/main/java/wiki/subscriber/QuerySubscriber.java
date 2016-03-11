package wiki.subscriber;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Wraps Esper Statement and Listener. No dependency on Esper libraries.
 */
@Component
public class QuerySubscriber implements StatementSubscriber {

	/**
	 * {@inheritDoc}
	 */
	public String getStatement() {

		return "select  character, count(*) as count from Character group by character having count(*)>0  order by count(*) desc limit 5";

	}

	/**
	 * Listener method called when Esper a batch is formed.
	 */
	public void update(Map<String, String> eventMap) {
		System.out.println(eventMap);
	}
}