package com.cloud.provider.service;

import com.cloud.provider.modal.Menu;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

@Component
public interface MenuService {
    public Menu queryMenuById(int menuId) throws Exception;
}
