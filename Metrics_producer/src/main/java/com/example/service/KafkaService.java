package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface KafkaService {
    void sendMessage(String message);
}
