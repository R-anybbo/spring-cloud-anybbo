package com.anybbo.api.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author huopengbo
 * @date 2019/01/14
 * @copyright © 2019 anybbo
 */
@Component
public class Sender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender: " + context);
        amqpTemplate.convertAndSend(context);
    }

}
