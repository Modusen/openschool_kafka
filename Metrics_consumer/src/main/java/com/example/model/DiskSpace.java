
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
public class DiskSpace {

    @JsonProperty("status")
    @Column(name = "DISK_SPACE_STATUS")
    private String status;
    @JsonProperty("details")
    @JoinColumn(name = "DISK_SPACE_DETAILS_ID")
    private Details details;
}
