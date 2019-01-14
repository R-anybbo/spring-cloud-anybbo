package com.anybbo.api;

import com.anybbo.api.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = RabbitMQApplication.class)
public class RabbitMQApplicationTests {

    @Resource
    private Sender sender;

    @Test
    public void contextLoads() {
        sender.send();
    }

}

