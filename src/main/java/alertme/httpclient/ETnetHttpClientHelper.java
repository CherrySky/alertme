package alertme.httpclient;

public class ETnetHttpClientHelper extends HttpClientHelper {

	private static String FEED_PRICE_KEYWORD = "<span class=\"Price ";

	public void inputPredicate(String inputLine, StringBuffer response) {
		if (inputLine.contains(FEED_PRICE_KEYWORD)) {
			response.append(inputLine.trim());
		}
	}

}
