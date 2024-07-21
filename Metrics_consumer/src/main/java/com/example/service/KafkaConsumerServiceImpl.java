package com.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @Autowired
    HealthMetricService service;

    @Override
    @KafkaListener(id = "MetricGroup", topics = "metrics-topic")
    public void listen(String message) {
        Assert.notNull(message, "Message is null");
        log.info("Reading message: {}", message);
        service.saveMetric(message);
        log.info("Message saved: {}", message);
    }

    @Override
    @KafkaListener(id = "DltGroup", topics = "metrics-topic.DLT")
    public void dltListen(byte[] in) {
        log.info("Getting from dlt: {}", Arrays.toString(in));
    }
}
