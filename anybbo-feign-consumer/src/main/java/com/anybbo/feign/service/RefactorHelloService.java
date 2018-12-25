package com.anybbo.feign.service;

import com.anybbo.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author huopengbo
 * @date 2018/12/23
 * @copyright © 2018 anybbo
 */
@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {

}
