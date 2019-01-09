package com.anybbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AnybboConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnybboConfigClientApplication.class, args);
    }

}

