package alertme.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import alertme.configuration.FeedServiceConfigurationContainer;

public class AlertmeMain {

	public static void main(String[] args) {
		new AlertmeMain().start();
	}

	private void start() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(FeedServiceConfigurationContainer.class);
		context.refresh();
		
		String say = (String) context.getBean("hello");
		
		System.out.println(say);
		
	}

}
