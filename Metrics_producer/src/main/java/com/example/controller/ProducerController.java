package com.example.controller;

import com.example.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ProducerController {

    private final ProducerService producerService;

    @Operation(summary = "Sending metrics", tags = "Kafka", description = "Sending metrics to Kafka from producer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @PostMapping("/send_metrics")
    public ResponseEntity<String> sendMetricsToKafka() {
        log.info("Start manual sending metrics");
        String metric = producerService.getMetrics();
        return ResponseEntity.ok(metric);
    }
}
