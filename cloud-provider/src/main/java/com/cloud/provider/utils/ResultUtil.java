package com.cloud.provider.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {

    /**
     * 处理成功返回协议对象
     * @return
     */
    public static Map<String, Object> returnSuccess(){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code","0");
        jsonMap.put("message","处理成功!");
        return jsonMap;
    }

    /**
     * 处理成功返回协议对象
     * @param jsonObject
     * @return
     */
    public static Map<String, Object> returnSuccess(Object jsonObject){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code","0");
        jsonMap.put("message","处理成功!");
        jsonMap.put("result", jsonObject);
        return jsonMap;
    }
}
