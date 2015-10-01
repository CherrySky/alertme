package alertme.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import alertme.configuration.ETnetFeedServiceConfiguration;

public class AlertmeMain {

	public static void main(String[] args) {
		new AlertmeMain().start();
	}

	private void start() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.register(FeedServiceConfiguration.class);
		//context.register(FeedConsumerServiceConfiguration.class);
		context.register(ETnetFeedServiceConfiguration.class);
		context.refresh();
		// GigaSpace space = (GigaSpace) context.getBean("space");
	}

	private void printit(Object obj) {
		System.out.println(obj.toString());
	}
}
