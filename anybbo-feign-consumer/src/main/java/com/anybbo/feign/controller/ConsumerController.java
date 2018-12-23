package com.anybbo.feign.controller;

import com.anybbo.api.model.User;
import com.anybbo.feign.service.HelloService;
import com.anybbo.feign.service.RefactorHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huopengbo
 * @date 2018/12/23
 * @copyright © 2018 anybbo
 */
@RestController
public class ConsumerController {

    @Resource
    private HelloService helloService;
    @Resource
    private RefactorHelloService refactorHelloService;

    @GetMapping(value = "/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping(value = "/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder builder = new StringBuilder();
        builder.append(helloService.hello()).append("\n");
        builder.append(helloService.hello1("ANYBBO")).append("\n");
        builder.append(helloService.hello2("ANYBBO1", 18)).append("\n");
        builder.append(helloService.hello3(new User("ANYBBO2", 23))).append("\n");
        return builder.toString();
    }

    @GetMapping(value = "/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder builder = new StringBuilder();
        builder.append(refactorHelloService.hello4("ANYBBO")).append("\n");
        builder.append(refactorHelloService.hello5("ANYBBO1", 18)).append("\n");
        builder.append(refactorHelloService.hello6(new User("ANYBBO2", 23))).append("\n");
        return builder.toString();
    }

}
