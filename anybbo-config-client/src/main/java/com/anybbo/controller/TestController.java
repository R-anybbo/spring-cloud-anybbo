package com.anybbo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huopengbo
 * @date 2019/01/07
 * @copyright © 2019 anybbo
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;


    @GetMapping("/from")
    public String from() {
        return this.from;
    }
}
