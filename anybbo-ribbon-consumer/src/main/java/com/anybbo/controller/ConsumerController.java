package com.anybbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author huopengbo
 * @date 2018/12/07
 * @copyright © 2018 anybbo
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

}
