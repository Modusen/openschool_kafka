
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HEALTH_METRIC")
public class HealthMetricEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonProperty("status")
    private String status;
    @JsonProperty("components")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "diskSpace.status", column = @Column(name = "DISK_SPACE_STATUS")),
            @AttributeOverride(name = "diskSpace.details", column = @Column(name = "DISK_SPACE_DETAILS"))

    })
    private Components components;
}
