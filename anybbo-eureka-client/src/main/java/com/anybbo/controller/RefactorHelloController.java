package com.anybbo.controller;

import com.anybbo.api.model.User;
import com.anybbo.api.service.HelloService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huopengbo
 * @date 2018/12/23
 * @copyright © 2018 anybbo
 */
@Log4j2
@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello4(@RequestParam("name") String name)  {
        return "Hello " + name;
    }

    @Override
    public User hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello6(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
