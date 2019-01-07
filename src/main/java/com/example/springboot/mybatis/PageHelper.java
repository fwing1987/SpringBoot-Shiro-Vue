package com.example.springboot.mybatis;

import java.util.HashMap;
import java.util.Map;

public class PageHelper {
    private static ThreadLocal<Map<String,Object>> threadMap = new ThreadLocal<Map<String,Object>>();
    private static final String TOTAL_COUNT = "TOTAL_COUNT";
    private static final String PAGE_NO = "PAGE_NO";
    private static final String PAGE_SIZE = "PAGE_SIZE";

    private static void setValue(String key,Object value){
        if(threadMap.get() == null){
            threadMap.set(new HashMap<>());
        }
        threadMap.get().put(key,value);
    }
    private static Object getValue(String key){
        return threadMap.get() == null?null:threadMap.get().get(key);
    }

    private static void remove(String key){
        if(threadMap.get() != null){
            threadMap.get().remove(key);
        }
    }

    public static void page(int pageNo,int pageSize){
        setValue(PAGE_NO,pageNo);
        setValue(PAGE_SIZE,pageSize);
    }
    public static Long getTotal(){
        return (Long)getValue(TOTAL_COUNT);
    }

    public static void setTotal(Long value){
        setValue(TOTAL_COUNT,value);
    }

    public static Integer getPage(){
        return (Integer) getValue(PAGE_NO);
    }

    public static Integer getPageSize(){
        return (Integer) getValue(PAGE_SIZE);
    }

    public static void clear(){
        remove(PAGE_NO);
        remove(PAGE_SIZE);
    }
}
