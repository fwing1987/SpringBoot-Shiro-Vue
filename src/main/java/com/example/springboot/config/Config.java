package com.example.springboot.config;

import com.example.springboot.dto.ApiFuncData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2018/4/26.
 */
public class Config {
    //页面api接口 start
    public static Map<String, ApiFuncData> API_FUNC_MAP = new HashMap<String, ApiFuncData>();

    static{
        putApiFunc("apiService","signin","signin");
        putApiFunc("apiService","logout","logout");
        putApiFunc("apiService","getUserInfo","getUserInfo");
    }

    private static void putApiFunc(String beanName,String method,String cmd){
        putApiFunc(beanName,method,cmd,false);
    }

    private static void putApiFunc(String beanName,String method,String cmd,boolean isNeedSign){
        ApiFuncData api = new ApiFuncData();
        api.beanName = beanName;
        api.method = method;
        api.isNeedSign = isNeedSign;
        API_FUNC_MAP.put(cmd,api);
    }
    //页面api接口 end

}
