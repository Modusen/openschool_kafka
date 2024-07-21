package com.example.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService {

    private final KafkaService kafkaService;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getMetrics() {
        log.info("Getting info from actuator");
        String URL = "http://localhost:8083/actuator/health/custom";
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        kafkaService.sendMessage(response.getBody());
        return response.getBody();
    }
}
