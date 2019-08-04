package com.BookStore.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
public class JmsConfiguration {
	
	@Value("${spring.activemq.broker-url}")
	private String brokerURL;
	
	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue("bookstatus.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory getActiveMQFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		return factory;
	}
	
	@Bean
	public JmsMessagingTemplate getJMSTemplate() {
		return new JmsMessagingTemplate(getActiveMQFactory());
		
	}

}
