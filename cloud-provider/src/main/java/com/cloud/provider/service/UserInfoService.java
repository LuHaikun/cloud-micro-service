package com.cloud.provider.service;

import com.cloud.provider.modal.UserInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

/**
 * @Created with IntelliJ IDEA.
 * @Description: cloud-micro-service
 * @Author: luhk
 * @Date: 2018-11-30
 * @Time: 5:07 PM
 * @Version: 1.0
 */
@Component
public interface UserInfoService {

    public UserInfo queryUserInfoByUserName(String userName);

    public PageInfo<UserInfo> queryUserInfoList(int currentPage, int pageSize);

}
