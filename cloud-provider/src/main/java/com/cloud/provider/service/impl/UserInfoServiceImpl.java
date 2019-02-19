package com.cloud.provider.service.impl;

import com.cloud.provider.dao.UserInfoDao;
import com.cloud.provider.modal.UserInfo;
import com.cloud.provider.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author: luhk
 * @Email lhk2014@163.com
 * @Date: 2018/11/30 4:52 PM
 * @Description:
 * @Created with cloud-micro-service
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public PageInfo<UserInfo> queryUserInfoList(int currentPage, int pageSize){
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        //全部商品
        List<UserInfo> userInfos = userInfoDao.queryUserInfoList();
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(userInfos);
        return pageInfo;
    }

    @Override
    public UserInfo queryUserInfoByUserName(String userName){
        return userInfoDao.queryUserInfoByUserName(userName);
    }
}
