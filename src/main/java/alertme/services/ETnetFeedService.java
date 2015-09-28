package alertme.services;

import org.openspaces.core.GigaSpace;

import alertme.httpclient.HttpClientHelper;

public class ETnetFeedService {

	private static String url = "https://www.etnet.com.hk/www/eng/stocks/realtime/quote.php?code=";
	private GigaSpace space;
	private HttpClientHelper httpClientHelper;

	public ETnetFeedService(GigaSpace space, HttpClientHelper httpClientHelper) {
		this.space = space;
		this.httpClientHelper = httpClientHelper;
	}

	public GigaSpace getSpace() {
		return space;
	}

	public ETnetFeedService start() {
		// TODO Auto-generated method stub
		return null;
	}

}
