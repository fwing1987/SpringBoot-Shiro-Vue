package com.example.springboot.controller;

import com.example.springboot.dto.Result;
import com.example.springboot.gentry.DnChannel;
import com.example.springboot.gentry.DnChannelMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class IndexController {
    Log log = LogFactory.getLog(IndexController.class);

    @Resource
    DnChannelMapper mapper;

    @RequestMapping
    @Transactional
    public void index(){
        log.error(mapper.selectAll());
        DnChannel channel = new DnChannel();
        channel.setPid(1);
        channel.setRootId(1);
        channel.setPhone("123");
        channel.setPassword("123");
        channel.setName("123");
        channel.setLevel((byte)0);
        mapper.insert(channel);
        throw new RuntimeException("1234");
//        return "/dist/index.html";
    }

    @RequestMapping("/unauth")
    @ResponseBody
    public Result unauth(){
        Result result = new Result(100);
        result.message = "未登录";
        return result;
    }
}
