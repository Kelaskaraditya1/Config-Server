package com.starkindustries.Config.Server.Mk2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyResponse {

    private Long id;

    private String application;

    private String profile;

    private String label;

    private String propKey;

    private String propValue;

    private Instant createdAt;

    private Instant updatedAt;
}
