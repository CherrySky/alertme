package alertme.configuration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import alertme.pojo.Quote;
import alertme.services.FeedService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeedServiceConfiguration.class})
public class FeedServiceConfigurationContainerTest {

	@Autowired
	FeedService feedService;

	@Test
	public void testFeedServiceConstructor() {
		Quote quote = new Quote();
		quote.setStockName("388");
		
		feedService.getSpace().write(quote);

		assertEquals("388", feedService.getSpace().read(quote).getStockName());
	}

}
