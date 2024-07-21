
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class Components {

    @JsonProperty("diskSpace")
    @Embedded
    private DiskSpace diskSpace;
    @JsonProperty("ping")
    @Embedded
    private Ping ping;
}
