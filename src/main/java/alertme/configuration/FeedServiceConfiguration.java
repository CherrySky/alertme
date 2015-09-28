package alertme.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(ETnetFeedServiceConfiguration.class)
@PropertySource("classpath:services.properties")
public class FeedServiceConfiguration {
	
	

}
