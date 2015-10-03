package alertme.configuration.scheduled.job;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.scheduled.job.ETnetScheduledJob;

import alertme.services.ETnetFeedService;

@Configuration
public class ETnetCronJobConfiguration {

	static final String EXPRESSION_2SEC = "0/2 * * ? * MON-SUN";
	
	@Autowired
	private ETnetFeedService etnetFeedService;
	
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {		
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(ETnetScheduledJob.class);		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("beanService", etnetFeedService);		
		factory.setJobDataAsMap(map);
		factory.setGroup("feedService");
		factory.setName("etnetFeedJob");
		return factory;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean() {		
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(jobDetailFactoryBean().getObject());
		stFactory.setStartDelay(0);
		stFactory.setName("mytrigger");
		stFactory.setGroup("mygroup");
		//stFactory.setCronExpression("0 0/1 * 1/1 * ? *");
		stFactory.setCronExpression(EXPRESSION_2SEC);
		
		return stFactory;
	}
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(cronTriggerFactoryBean().getObject());
		return scheduler;
	}

}
