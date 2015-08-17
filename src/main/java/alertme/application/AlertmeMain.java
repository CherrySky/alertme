package alertme.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import alertme.configuration.GigaspaceServiceConfiguration;

public class AlertmeMain {

	public static void main(String[] args) {
		new AlertmeMain().start();
	}

	private void start() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(GigaspaceServiceConfiguration.class);
		context.refresh();
		// GigaSpace space = (GigaSpace) context.getBean("space");
	}

	private void printit(Object obj) {
		System.out.println(obj.toString());
	}
}
