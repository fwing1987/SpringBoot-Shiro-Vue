package com.example.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.config.Config;
import com.example.springboot.dto.ApiFuncData;
import com.example.springboot.dto.Result;
import com.example.springboot.util.JSONUtil;
import com.example.springboot.util.SpringContextHolder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@CrossOrigin
@Controller
public class ApiController {
    Log log = LogFactory.getLog(ApiController.class);
    @RequestMapping(value = "/api",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String api(HttpServletRequest request) {
        Result result = new Result(1);
//        ThreadContext.unbindSubject();
//        if(StringUtils.isNotEmpty(request.getHeader("X-TOKEN"))) {
//            Subject subject = (new Subject.Builder()).sessionId(request.getHeader("X-TOKEN")).buildSubject();
//            if (subject != null) {
//                ThreadContext.bind(subject);
//            }
//        }
        try {
            String jsonString = IOUtils.toString(request.getInputStream(), "utf-8");
            log.info("收到请求:" + jsonString);
            JSONObject json = JSONObject.parseObject(jsonString);
            json.put("clientIp", request.getRemoteAddr());
            json.put("referer", request.getHeader("referer"));
            json.put("hostUrl", request.getScheme() +"://" + request.getServerName());

            String cmd = json.getString("cmd");
            do {
                if (StringUtils.isEmpty(cmd)) {
                    result.message = "缺失参数";
                    break;
                } else if (!Config.API_FUNC_MAP.containsKey(cmd)) {
                    result.message = "接口不存在";
                    break;
                }

                ApiFuncData api = Config.API_FUNC_MAP.get(cmd);
                Object o = SpringContextHolder.getBean(api.beanName);
                Method callMethod = o.getClass().getMethod(api.method, JSONObject.class);

                result = (Result) callMethod.invoke(o, json);

            } while (false);
        }catch (InvocationTargetException e) {
            if(e.getTargetException() instanceof  RuntimeException){
                if(e.getTargetException().getMessage() == null){
                    log.error("调用接口错误：",e.getTargetException());
                }else{
                    log.error(e.getTargetException().getMessage());
                }
            }else {
                log.error("调用接口错误：", e.getTargetException());
            }
            result.message = e.getTargetException().getMessage();
        }catch(LockedAccountException e){
            result.message = "用户被冻结~";
        }catch(UnauthenticatedException e){
            result.message = "需要登录~";
        }catch(UnauthorizedException e){
            result.message = "权限不足~";
        }catch (Exception e) {
            log.error("调用接口错误：", e);
            result.message = e.getMessage();
        }

        String retJson = JSONUtil.toJson(result);
        log.info("返回：" + retJson);
        return retJson;
    }
}
