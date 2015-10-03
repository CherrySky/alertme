package alertme.services;

import org.openspaces.core.GigaSpace;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

import alertme.httpclient.HttpClientHelper;

public class ETnetFeedService {

	private static String url = "https://www.etnet.com.hk/www/eng/stocks/realtime/quote.php?code=";
	private GigaSpace space;
	private HttpClientHelper httpClientHelper;

	public static final String COUNT = "count";


	public ETnetFeedService(GigaSpace space, HttpClientHelper httpClientHelper) {		
		this.space = space;
		this.httpClientHelper = httpClientHelper;
	}

	public GigaSpace getSpace() {
		return space;
	}

	public void grepFeed() {
		System.out.println("grep feed! " + this.hashCode());
		
	}

}
