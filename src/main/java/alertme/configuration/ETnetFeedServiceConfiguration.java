package alertme.configuration;

import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import alertme.configuration.scheduled.job.ETnetCronJobConfiguration;
import alertme.httpclient.ETnetHttpClientHelper;
import alertme.httpclient.HttpClientHelper;
import alertme.services.ETnetFeedService;

@Configuration
@Import({GigaspaceServiceConfiguration.class, ETnetCronJobConfiguration.class})
@PropertySource("classpath:services.properties")
public class ETnetFeedServiceConfiguration {
	
	@Autowired
	GigaSpace space;
	
	@Bean
	public ETnetFeedService etnetFeedService() {		
		return new ETnetFeedService(space, etnetHttpClientHelper());
	}
	
	private HttpClientHelper etnetHttpClientHelper() {
		return new ETnetHttpClientHelper();
	}
	
	

}
