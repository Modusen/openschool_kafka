package com.example.service;

import com.example.exception.NotFoundException;
import com.example.model.HealthMetricEntity;
import com.example.repository.HealthMetricRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HealthMetricServiceImpl implements HealthMetricService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final HealthMetricRepository repository;

    @Override
    public void saveMetric(String metric) {
        try {
            HealthMetricEntity healthMetric = mapper.readValue(metric, HealthMetricEntity.class);
            repository.save(healthMetric);
        } catch (JsonProcessingException e) {
            log.error("Error due to parsing metric: {}", metric);
            throw new RuntimeException(e);
        }
    }

    @Override
    public HealthMetricEntity getMetricById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("HealthMetric with ID:" + id + " is not found")
                );
    }

    @Override
    public List<HealthMetricEntity> getAllMetrics() {
        return repository.findAll();
    }
}
