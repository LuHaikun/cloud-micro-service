package com.cloud.provider.modal;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: luhk
 * @Email lhk2014@163.com
 * @Date: 2018/11/30 1:57 PM
 * @Description: 用户对象
 * @Created with cloud-micro-service
 * @Version: 1.0
 */
@Data
public class UserInfo implements Serializable {
    //用户id
    private String id;
    //用户名称
    private String username;
    //邮箱
    private String email;
    //密码
    private String secretcode;
    //
    private Integer activated;
    //
    private String activationkey;
    //
    private String resetpasswordkey;
    //状态
    private Integer state;
    //备注
    private String remarks;
}
