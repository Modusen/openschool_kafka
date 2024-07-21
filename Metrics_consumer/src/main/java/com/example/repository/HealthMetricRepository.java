package com.example.repository;

import com.example.model.HealthMetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthMetricRepository extends JpaRepository<HealthMetricEntity, Long> {
}
