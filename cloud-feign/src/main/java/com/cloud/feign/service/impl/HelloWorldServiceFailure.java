package com.cloud.feign.service.impl;

import com.cloud.feign.service.HelloWorldService;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceFailure implements HelloWorldService {
    @Override
    public String helloWorld() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }
}
