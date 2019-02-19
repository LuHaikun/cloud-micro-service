package com.cloud.provider.controller.rest;


import com.cloud.provider.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = { "项目相关API" })
@RequestMapping(value = "/V1.0")
public class HelloWorldController {

    @Autowired
    private RedisService redisService;

    @Value("${server.port}")
    String port;
    @ApiOperation(value="项目分页列表", httpMethod ="GET", notes ="分页查询项目")
    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld() {
        log.info("前台日志："+"HelloWorld---port:"+port);
//        redisService.set("key", "12qew3");
		return "HelloWorld---port:"+port;
    }
	
}
