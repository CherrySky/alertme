package alertme.configuration;

import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import alertme.httpclient.ETnetHttpClientHelper;
import alertme.httpclient.HttpClientHelper;
import alertme.services.ETnetFeedService;

@Configuration
@Import(GigaspaceServiceConfiguration.class)
@PropertySource("classpath:services.properties")
public class ETnetFeedServiceConfiguration {
	
	@Autowired
	GigaSpace space;
	
	@Bean
	public ETnetFeedService etnetFeedService() {
		System.out.println("ETnet feed space: " + space.hashCode());
		return new ETnetFeedService(space, etnetHttpClientHelper()).start();
	}
	
	private HttpClientHelper etnetHttpClientHelper() {
		return new ETnetHttpClientHelper();
	}

}
