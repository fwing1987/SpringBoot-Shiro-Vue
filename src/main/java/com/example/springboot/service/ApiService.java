package com.example.springboot.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dao.SysMenuDao;
import com.example.springboot.dao.SysUserDao;
import com.example.springboot.dto.Result;
import com.example.springboot.entity.SysUserEntity;
import com.example.springboot.util.ValidateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class ApiService {
    Log log = LogFactory.getLog(ApiService.class);
    @Resource
    SysUserDao sysUserDao;
    @Resource
    SysMenuDao sysMenuDao;
    @Resource
    private SecurityManager securityManager;

    @PostConstruct
    private void initStaticSecurityManager() {
        SecurityUtils.setSecurityManager(securityManager);
    }

    public Result signin(JSONObject json){
        ValidateUtil.validJSONParam(json, "username","password");

        String username = json.getString("username");
        String password = json.getString("password");

        Result result = new Result();
//        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username,password));

        SysUserEntity user = (SysUserEntity)subject.getPrincipal();

        result.message = "登录成功~";
        result.body = subject.getSession().getId();
        return result;
    }

    @RequiresAuthentication
    public Result getUserInfo(JSONObject json){
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();

        JSONObject retJson = (JSONObject)JSON.toJSON(user);
        retJson.remove("password");
        retJson.remove("id");
        retJson.remove("salt");

        Result result = new Result();
        result.body = retJson;
        return result;
    }

    public Result logout(JSONObject json){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Result result = new Result();
        result.message = "登出成功~";
        return result;
    }
}
