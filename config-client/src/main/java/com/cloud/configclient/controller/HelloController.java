package com.cloud.configclient.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(value = "/V1.0")
public class HelloController {

    @Value("${hello}")
    String hello;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
      
		return hello;
    }
	
}
