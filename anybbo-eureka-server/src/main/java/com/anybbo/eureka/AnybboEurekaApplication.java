package com.anybbo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AnybboEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnybboEurekaApplication.class, args);
    }
}
