package com.scheduled.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import alertme.services.ETnetFeedService;

public class ETnetScheduledJob extends QuartzJobBean {

	private ETnetFeedService feedService;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		feedService.grepFeed();
	}

	public void setBeanService(ETnetFeedService anotherBean) {
		this.feedService = anotherBean;
	}
}
