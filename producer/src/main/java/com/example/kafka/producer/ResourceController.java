package com.example.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.model.Notification;

@RestController
@RequestMapping(value = "produce")
public class ResourceController {
	@Autowired
	KafkaTemplate<String, Notification> kafkaTemplate;

	@GetMapping("/send/{source}/{hostKey}/{actor}")
	public String sendMessage(@PathVariable("source") final String source,
			@PathVariable("hostKey") final String hostKey, @PathVariable("actor") final String actor) {
		Notification notification = new Notification();
		notification.setActor(actor);
		notification.setHostKey(hostKey);
		notification.setSource(source);
		notification.setCode("test");
		kafkaTemplate.send("NDS-Topic1", notification);
		return "sent successfully!";

	}

}
