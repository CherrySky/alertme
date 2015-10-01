package alertme.configuration;

import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import alertme.httpclient.ETnetHttpClientHelper;
import alertme.httpclient.HttpClientHelper;
import alertme.services.ETnetFeedService;

@Configuration
@Import({GigaspaceServiceConfiguration.class})
@PropertySource("classpath:services.properties")
public class ETnetFeedServiceConfiguration {
	
	@Autowired
	GigaSpace space;
	
	@Bean
	public ETnetFeedService etnetFeedService() {
		System.out.println("ETnet feed space: " + space.hashCode());
		return new ETnetFeedService(space, etnetHttpClientHelper());
	}
	
	private HttpClientHelper etnetHttpClientHelper() {
		return new ETnetHttpClientHelper();
	}
	
	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetBeanName("etnetFeedService");
		bean.setTargetMethod("grepFeed");
		return bean;
	}

	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
		SimpleTriggerFactoryBean simpleTrigger = new SimpleTriggerFactoryBean();
		simpleTrigger.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
		simpleTrigger.setStartDelay(1000);
		simpleTrigger.setRepeatInterval(2000);
		return simpleTrigger;
	}
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(simpleTriggerFactoryBean().getObject());
		return scheduler;
	}

}
