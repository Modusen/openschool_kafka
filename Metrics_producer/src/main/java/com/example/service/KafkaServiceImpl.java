package com.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        log.info("Sending message to Kafka: {}", message);
        kafkaTemplate.send("metrics-topic", message);
        log.info("Message sent");
    }
}
