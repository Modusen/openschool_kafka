
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Ping {

    @JsonProperty("status")
    @Column(name = "PING_STATUS")
    private String status;
}
