package com.anybbo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author huopengbo
 * @date 2018/12/15
 * @copyright © 2018 anybbo
 */
@Log4j2
@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helleFallback", commandKey = "helloKey", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")
    })
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    public String helleFallback() {
        return "error";
    }

}
