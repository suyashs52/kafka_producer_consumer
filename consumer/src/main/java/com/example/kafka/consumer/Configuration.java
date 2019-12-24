package com.example.kafka.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.kafka.producer.model.Notification;

@EnableKafka
@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Notification> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Notification> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(config());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, Notification> config() {
		Map<String, Object> map = new HashMap<>();
		// bootstrap.server
		map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		// key.deserializer
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		// value.deserializer
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		map.put(ConsumerConfig.GROUP_ID_CONFIG, "group_1");
		final JsonDeserializer<Notification> jsonDeserializer = new JsonDeserializer<>(Notification.class);
		jsonDeserializer.addTrustedPackages("*");
		return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), jsonDeserializer);
		// return new DefaultKafkaConsumerFactory<>(map);

	}

}
