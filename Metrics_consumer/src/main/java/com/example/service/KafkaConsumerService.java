package com.example.service;

public interface KafkaConsumerService {
    void listen(String message);
    void dltListen(byte[] in);
}
