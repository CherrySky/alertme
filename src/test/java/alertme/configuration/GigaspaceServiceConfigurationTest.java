package alertme.configuration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import alertme.pojo.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GigaspaceServiceConfiguration.class})
public class GigaspaceServiceConfigurationTest {

	@Autowired
	GigaSpace space;

	@Test
	public void testCreationOfSpace() {
		Quote quote = new Quote();
		quote.setStockName("388");

		space.write(quote);

		assertEquals("388", space.read(quote).getStockName());
	}

}
