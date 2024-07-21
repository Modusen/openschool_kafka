package com.example.service;

import com.example.model.HealthMetricEntity;

import java.util.List;

public interface HealthMetricService {
    void saveMetric(String metric);

    HealthMetricEntity getMetricById(Long id);

    List<HealthMetricEntity> getAllMetrics();
}
