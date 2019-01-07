package com.example.springboot.controller;

import com.example.springboot.dto.Result;
import com.example.springboot.gentry.DnChannel;
import com.example.springboot.gentry.DnChannelMapper;
import com.example.springboot.mybatis.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {
    Log log = LogFactory.getLog(IndexController.class);

    @Resource
    DnChannelMapper mapper;

    @RequestMapping
    public String index(){
        return "/dist/index.html";
    }

    @RequestMapping("/test")
    public void test(){
        try {
            PageHelper.page(1,10);
            log.error(mapper.getUserPromotionByPage(100438,"2018-10-10%",null));
//            mapper.selectAll();
            PageHelper.page(1,5);
            log.error(mapper.selectAll());
            //TODO 因为使用了缓存，导致第二次查询没有启用prepare的Interceptor，返回了第一次查询的数据
            PageHelper.page(2,5);
            log.error(mapper.selectAll());
        }catch (Exception e){
            log.error(e);
        }
    }

    @RequestMapping("/unauth")
    @ResponseBody
    public Result unauth(){
        Result result = new Result(100);
        result.message = "未登录";
        return result;
    }
}
