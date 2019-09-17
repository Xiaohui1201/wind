package com.windcloud.windeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WindEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindEurekaApplication.class, args);
    }

}
