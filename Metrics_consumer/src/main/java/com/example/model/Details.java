
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Details {

    @JsonProperty("total")
    private Long total;
    @JsonProperty("free")
    private Long free;
    @JsonProperty("threshold")
    private Integer threshold;
    @JsonProperty("path")
    private String path;
    @JsonProperty("exists")
    private Boolean exists;
}
