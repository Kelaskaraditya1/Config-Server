package com.starkindustries.config_server.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "build")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuildConfiguration {

    private String id;
    private String version;
    private String type;
    private String name;
}
