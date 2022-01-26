package com.esprit.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
@PropertySource("classpath:application.yml")
public class TopicListener {

	@Value("${topic.name.consumer}")
	private String topicName;

	@KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		System.out.println("Topic: {}" + topicName);
		System.out.println("key: {}" + payload.key());
		System.out.println("Headers: {}" + payload.headers());
		System.out.println("Partion: {}" + payload.partition());
		System.out.println("Order: {}" + payload.value());
	}

}