package com.starkindustries.Config.Server.Mk2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerMk2Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMk2Application.class, args);
	}

}

