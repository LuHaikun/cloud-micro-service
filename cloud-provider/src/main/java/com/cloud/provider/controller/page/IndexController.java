package com.cloud.provider.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/V1.0")
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
