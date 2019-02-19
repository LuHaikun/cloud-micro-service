package com.cloud.provider.dao;

import com.cloud.provider.modal.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoDao {

    UserInfo queryUserInfoByUserName(String userName);

    List<UserInfo> queryUserInfoList();
}
