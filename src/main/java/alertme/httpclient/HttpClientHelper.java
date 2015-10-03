package alertme.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientHelper {

	private final String USER_AGENT = "Mozilla/5.0";

	public String sendGet(String url) throws Exception {

		// String url =
		// "https://reserve.cdn-apple.com/HK/en_HK/reserve/iPhone/availability.json";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			inputPredicate(inputLine, response);
			//response.append(inputLine);
		}
		in.close();

		// print result
		//System.out.println(response.toString());
		return response.toString();

	}

	public void inputPredicate(String inputLine, StringBuffer response) {
		response.append(inputLine);		
	}
}
