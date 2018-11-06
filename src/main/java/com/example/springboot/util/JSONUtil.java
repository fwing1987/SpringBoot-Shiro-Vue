package com.example.springboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by wangfeng on 17/1/9.
 */
public class JSONUtil {
    public static String toJson(Object o){
        return JSON.toJSONString(o, SerializerFeature.WriteDateUseDateFormat);
    }

    public static JSONObject fromJson(String json){
        return JSON.parseObject(json);
    }

    public static JSONObject fromObject(Object o){
        return JSON.parseObject(toJson(o));
    }

    public static <T> T toObject(String json,Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }
}
