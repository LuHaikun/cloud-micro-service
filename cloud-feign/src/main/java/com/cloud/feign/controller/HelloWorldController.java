package com.cloud.feign.controller;


import com.cloud.feign.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/V1.0")
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;
    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld() {
        return helloWorldService.helloWorld();
    }
	
}
