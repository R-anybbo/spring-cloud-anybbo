package com.anybbo.controller;

import com.anybbo.api.model.User;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author huopengbo
 * @date 2018/12/07
 * @copyright © 2018 anybbo
 */
@Log4j2
@RestController
public class HelloController {

    @Resource
    private DiscoveryClient discoveryClient;

    @SneakyThrows
    @GetMapping(value = "/hello")
    String hello() {
        int randomSleep = new Random().nextInt(3000);
        log.info("sleepTime:" + randomSleep);
        Thread.sleep(randomSleep);

        discoveryClient.getServices().parallelStream()
                .map(key -> discoveryClient.getInstances(key))
                .forEach(value -> {
                    value.forEach(v -> {
                        log.info("/hello host:" + v.getHost() + " service_id:" + v.getServiceId());
                    });
                });
        return "Hello Word";
    }

    @GetMapping(value = "hello1")
    String hello1(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "hello2")
    User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping(value = "hello3")
    String hello3(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
