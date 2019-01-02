package com.anybbo.feign.service;

import com.anybbo.api.model.User;
import com.anybbo.feign.config.DisableHystrixConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author huopengbo
 * @date 2018/12/23
 * @copyright © 2018 anybbo
 */
@FeignClient(value = "HELLO-SERVICE", configuration = DisableHystrixConfiguration.class)
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello1(@RequestParam("name") String name);

    @GetMapping("/hello2")
    String hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello3(@RequestBody User user);

}
