package com.cloud.provider.controller.rest;


import com.cloud.provider.modal.Menu;
import com.cloud.provider.service.MenuService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/V1.0")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Value("${server.port}")
    String port;
    @RequestMapping(value = "/queryMenuById", method = RequestMethod.GET)
    public Menu queryMenuById(int menuId) throws Exception {
        Menu menu = menuService.queryMenuById(menuId);
		return menu;
    }
	
}
