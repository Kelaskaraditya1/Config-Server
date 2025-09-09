package com.starkindustries.config_server.controller;

import com.starkindustries.config_server.configuration.BuildConfiguration;
import com.starkindustries.config_server.keys.Keys;
import com.starkindustries.config_server.model.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    public Configuration configuration;

    @Autowired
    public BuildConfiguration buildConfiguration;

    @GetMapping("/greetings")
    public ResponseEntity<?> greetings(){
        Map<String,Object> response = new HashMap<>();

        response.put(Keys.TIME_STAMP, Instant.now());
        response.put(Keys.STATUS, HttpStatus.OK.value());
        response.put(Keys.MESSAGE,"Greetings,I am Optimus Prime!!");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/build-info")
    public ResponseEntity<?> buildInfo(){
        Map<String,Object> response = new HashMap<>();

        response.put(Keys.TIME_STAMP, Instant.now());
        response.put(Keys.STATUS, HttpStatus.OK.value());
        response.put(Keys.MESSAGE,"Configurations fetched successfully!!");
//        log.info("configuration:{}",configuration);
        response.put(Keys.BODY,configuration);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
