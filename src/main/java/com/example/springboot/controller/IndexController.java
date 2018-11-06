package com.example.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dao.DnPromotionInfoDao;
import com.example.springboot.dto.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class IndexController {
    Log log = LogFactory.getLog(IndexController.class);
    @RequestMapping
    public String index(){

        return "/dist/index.html";
    }

    @RequestMapping("/unauth")
    @ResponseBody
    public Result unauth(){
        Result result = new Result(100);
        result.message = "未登录";
        return result;
    }
}
