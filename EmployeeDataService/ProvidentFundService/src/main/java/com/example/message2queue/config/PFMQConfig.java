package com.example.message2queue.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class PFMQConfig {
	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("employee.queue");
	}
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerUrl);
		return factory;
	}
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}

}
