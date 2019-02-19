package com.cloud.provider.modal;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Data
@Document(indexName = "cloud_test", type = "menus") // indexName代表所以名称,type代表表名称
public class Menu implements Serializable {
    //菜单id
    private String id;
    //菜单名称
    private String nameCh;
    //菜单英文名
    private String nameEn;
    //父级id
    private String parenrId;
    //菜单英文名
    private String orderId;
    //菜单权限
    private String menuAuth;
    //权限
    private String authId;
}
