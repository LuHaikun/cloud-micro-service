package com.cloud.provider.modal;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: luhk
 * @Email lhk2014@163.com
 * @Date: 2018/11/30 1:55 PM
 * @Description: 角色对象
 * @Created with cloud-micro-service
 * @Version: 1.0
 */
@Data
public class Role implements Serializable{
    //角色id
    private String id;
    //角色名称
    private String rolename;
    //角色备注
    private String remarks;
}
