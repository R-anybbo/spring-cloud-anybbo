package com.anybbo.api.service;

import com.anybbo.api.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author huopengbo
 * @date 2018/12/23
 * @copyright © 2018 anybbo
 */
@RequestMapping("/refactor")
public interface HelloService {

    @GetMapping("/hello4")
    String hello4(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello6")
    String hello6(@RequestBody User user);

}
