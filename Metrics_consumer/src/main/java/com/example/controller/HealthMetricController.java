package com.example.controller;

import com.example.model.HealthMetricEntity;
import com.example.service.HealthMetricService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class HealthMetricController {
    @Autowired
    private HealthMetricService healthMetricService;
    @Operation(summary = "Get all", tags = "Consumer", description = "Get all metrics from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @GetMapping("/metrics")
    public List<HealthMetricEntity> getAllMetrics() {
        return healthMetricService.getAllMetrics();
    }

    @Operation(summary = "Get by ID", tags = "Consumer", description = "Get metric by ID from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @GetMapping("/metrics/{id}")
    public HealthMetricEntity getMetricById(@PathVariable Long id) {
        return healthMetricService.getMetricById(id);
    }
}
