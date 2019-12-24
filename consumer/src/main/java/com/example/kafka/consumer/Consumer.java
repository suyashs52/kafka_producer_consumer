package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.producer.model.Notification;

@Service
public class Consumer {
	@KafkaListener(topics = "NDS-Topic1",groupId = "group_1",containerFactory = "kafkaListenerContainerFactory")
	public void consumeJson(Notification notification) {
		System.out.println("value:" + notification);
	}
}
