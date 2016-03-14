package wiki.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import wiki.data.Data;
import wiki.listener.CountListener;
import wiki.listener.QueryListener;
import wiki.listener.TypeListener;

/**
 * This class handles incoming Data. It processes them through the EPService, to
 * which it has the query attached.
 */
@Component
@Scope(value = "singleton")
public class StreamHandler implements InitializingBean {

	/** Logger */
	private static Logger LOG = LoggerFactory.getLogger(StreamHandler.class);

	/** Esper service */
	private EPServiceProvider epService;
	private EPStatement eventStatement;

	@Autowired
	@Qualifier("queryListener")
	private QueryListener queryListener;

	@Autowired
	@Qualifier("countListener")
	private CountListener countListener;

	@Autowired
	@Qualifier("typeListener")
	private TypeListener typeListener;

	/**
	 * Configure Esper Statement(s).
	 */
	public void initService() {

		LOG.debug("Initializing Service ..");
		Configuration config = new Configuration();
		config.addEventTypeAutoName("wiki.data");
		epService = EPServiceProviderManager.getDefaultProvider(config);

		createWindow();
		insertIntoWindow();
		createExpression();
		countOfFeeds();
		countOfTypeOfFeeds();

	}

	private void insertIntoWindow() {
		String query = "insert into Character select title.substring(0,1) as character from Data";
		epService.getEPAdministrator().createEPL(query);
	}

	private void createWindow() {

		epService.getEPAdministrator()
				.createEPL("create window Character.win:time_batch(300 sec) as (character string)");

	}

	private void createExpression() {

		eventStatement = epService.getEPAdministrator().createEPL(
				"select  character, count(*) as count from Character group by character having count(*)>0  order by count(*) desc limit 5");

		eventStatement.addListener(queryListener);
	}

	private void countOfFeeds() {

		eventStatement = epService.getEPAdministrator()
				.createEPL("select  count(*) as count from Data.win:time_batch(300 sec)");

		eventStatement.addListener(countListener);
	}

	private void countOfTypeOfFeeds() {

		eventStatement = epService.getEPAdministrator()
				.createEPL("select  type as type,count(*) as count from Data.win:time_batch(300 sec) group by type");

		eventStatement.addListener(typeListener);
	}

	/**
	 * Handle the incoming TemperatureEvent.
	 */
	public void handle(Data data) {

		epService.getEPRuntime().sendEvent(data);

	}

	public void afterPropertiesSet() {

		LOG.debug("Configuring..");
		initService();
	}
}
