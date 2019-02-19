package com.cloud.feign.service;

import com.cloud.feign.service.impl.HelloWorldServiceFailure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "EUREKA-PROVIDER", fallback = HelloWorldServiceFailure.class)
public interface HelloWorldService {
    @RequestMapping(value = "/V1.0/helloWorld",method = RequestMethod.GET)
    public String helloWorld();
}
