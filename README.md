&#160; &#160; &#160; &#160;所有源码可以在[github](https://github.com/fwing1987/SpringBoot-Shiro-Vue.git)上找到，文章参考：
[提供一套基于Spring Boot-Shiro-Vue的权限管理思路.前后端都加以控制,做到按钮/接口级别的权限](https://github.com/Heeexy/SpringBoot-Shiro-Vue)，做了自己的实现，练了下手。前文见：[前后端分离项目中权限控制的思考](https://blog.csdn.net/pur_e/article/details/83506888)，以及实现过程中的瞎折腾：[SpringBoot+Shiro瞎折腾——不使用Shiro的Filter模式](https://blog.csdn.net/pur_e/article/details/83749624)。  
&#160; &#160; &#160; &#160;PS:前端代码使用的是：[vue-admin-template](https://github.com/PanJiaChen/vue-admin-template)
# 一、Shiro基本概念
&#160; &#160; &#160; &#160;参见前文：[Shiro基本概念](https://blog.csdn.net/pur_e/article/details/83344041)，里面有些术语理解起来可能没那么直观，配合下面的实例代码，看看是如何使用的，可以辅助理解。  
&#160; &#160; &#160; &#160;

# 二、WEB的典型用户验证流程

```sequence
Title:web权限验证简图
participant Cookie
participant 浏览器
participant 服务端
participant SessionManager
note over 浏览器:登录
浏览器->>服务端:用户名/密码
服务端->>SessionManager:登录成功，保存session
服务端->>浏览器:返回sessionId
浏览器->>Cookie:保存sessionId
note over 浏览器:取用户信息
Cookie->>浏览器:取sessionId
浏览器->>服务端:sessionId
SessionManager->>服务端:取session
服务端->>浏览器:验证并返回用户信息
```
&#160; &#160; &#160; &#160;特意将Cookie与SessionManager单独出来，是因为这两个是可选的，可配的：
* Cookie可以选择不使用，只将sessionId存放在页面的内存中，这时页面被关闭，sessionId也就丢失了，当然，服务端还存在一个类似野指针的session；也可以选择使用localStorage；
* SessionManager，Shiro提供一个默认的DefaultWebSessionManager，是使用MemorySessionDAO在服务端的内存中保存session，但存在几个问题，不推荐在生产环境中使用：
    1. 无法持久化，服务端重启下session就丢了；
    2. 容易内存溢出；
    3. 集群模式下无法session共享；
    
# 三、实现
&#160; &#160; &#160; &#160;理一下思路，前后端分离权限验证与普通Web服务的权限验证有啥不同，其实就一个：```前后端变成了只交互数据```，展开来说，是后端少了两个对前端的控制：
* ```页面路由```
* ```页面DOM```

&#160; &#160; &#160; &#160;所以针对普通的web服务，需要做出如下修改：
1. 路由相关：
    * 未验证页面不能直接Shiro跳转，而是返回未登录错误，由前端实现
    ```java
    shiroFilterFactoryBean.setLoginUrl("/unauth");
    @RequestMapping("/unauth")
    @ResponseBody
    public Result unauth(){
        Result result = new Result(100);
        result.message = "未登录";
        return result;
    }
    ```
    * 配置所有URL为不需要登录验证，而由前端根据后端返回的权限数据来路由(别和不需要权限验证混了，只是因为路由不需要后端来做而已，所有需要权限验证的业务逻辑都需要有权限较验)
    ```java
    filterChainDefinitionMap.put("/", "anon");
    ```
    * 前端需要根据返回的权限数据进行路由配置，具体到Vue使用Vue router的addRoutes动态添加路由

2. DOM相关
    * 前端根据后端返回的权限数据决定菜单或按钮的展示

3. 跨域，这个是前后端分离带来的新问题(如果分开部署)
    * 后端需要配置允许跨域(添加@CrossOrigin或使用Filter)

&#160; &#160; &#160; &#160;没了，就需要修改这么多，具体实现就不贴大量代码了，源码见[github](https://github.com/fwing1987/SpringBoot-Shiro-Vue.git)。后续再尝试添加一下Redis的Session支持

