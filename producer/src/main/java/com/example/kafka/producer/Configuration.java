package com.example.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.kafka.producer.model.Notification;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public KafkaTemplate<String, Notification> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, Notification> producerFactory() {
		return new DefaultKafkaProducerFactory<>(config());
	}

	public Map<String, Object> config() {
		Map<String, Object> map = new HashMap<>();
		// bootstrap.server
		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		// key.serializer
		map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		// value.serializer

		map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return map;

	}
}
