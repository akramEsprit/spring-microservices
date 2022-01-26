package com.esprit.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ProducerResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerResourceApplication.class, args);
	}
}
