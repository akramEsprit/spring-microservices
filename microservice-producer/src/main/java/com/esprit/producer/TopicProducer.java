package com.esprit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.yml")
public class TopicProducer {

	@Value("${topic.name.producer}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
		System.out.println("message de test: {}" + message);
		this.kafkaTemplate.send(topicName, message);
	}

}
