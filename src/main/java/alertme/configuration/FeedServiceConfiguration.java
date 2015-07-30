package alertme.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeedServiceConfiguration {
	
	@Bean
	public String hello() {
		return "hello";
	}

}
