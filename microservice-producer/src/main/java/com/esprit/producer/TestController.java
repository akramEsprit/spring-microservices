package com.esprit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private TopicProducer topicProducer;

	@RequestMapping(method = RequestMethod.GET, value = "/api/produce/")
	public String getTokenDetails(@RequestHeader HttpHeaders headers) {
		topicProducer.send("Message de test");
		return headers.toString();
	}

}
