package com.starkindustries.Config.Server.Mk2.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyRequest {

    private String application;

    private String profile;

    private String label;

    private String propKey;

    private String propValue;

}
