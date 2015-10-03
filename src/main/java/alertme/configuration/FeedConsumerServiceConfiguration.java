package alertme.configuration;

import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import alertme.services.FeedConsumerService;

@Configuration
@Import(GigaspaceServiceConfiguration.class)
@PropertySource("classpath:services.properties")
public class FeedConsumerServiceConfiguration {
	
	@Autowired
	GigaSpace space;
	
	@Bean
	public FeedConsumerService consumerService() {		
		return new FeedConsumerService(space);
	}

}
