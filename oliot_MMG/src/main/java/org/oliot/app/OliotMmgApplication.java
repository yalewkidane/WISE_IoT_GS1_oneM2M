package org.oliot.app;

import org.oliot.bis.accessingApp.PublisherMQTT;
import org.oliot.bis.accessingApp.SubscriberThread;
import org.oliot.bis.configuration.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.oliot.bis.controller"})
public class OliotMmgApplication {

	public static void main(String[] args) {
		new Configuration();
//		SubscriberThread sbscriberThread=new SubscriberThread();
//		sbscriberThread.start();
//		
//		
//		PublisherMQTT publisherMQTT=new PublisherMQTT();
//		publisherMQTT.initialize();
		
		Configuration.logger.info("MMG_Started");
		SpringApplication.run(OliotMmgApplication.class, args);
	}
}
