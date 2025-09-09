package com.starkindustries.config_server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Configuration {

    @Value("${build.id}")
    private String buildId;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.name}")
    private String buildName;

    @Value("${build.type}")
    private String buildType;
}
