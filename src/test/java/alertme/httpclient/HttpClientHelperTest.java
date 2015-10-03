package alertme.httpclient;

import org.junit.Before;
import org.junit.Test;

public class HttpClientHelperTest {

	HttpClientHelper helper = null;

	@Before
	public void setup() {
		helper = new HttpClientHelper();
	}

	@Test
	public void testSendGet() throws Exception {
		String url = "https://www.etnet.com.hk/www/eng/stocks/realtime/quote.php?code=5";
		System.out.println(helper.sendGet(url));
	}

}
