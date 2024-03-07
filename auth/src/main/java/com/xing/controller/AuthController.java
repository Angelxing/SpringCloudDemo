package com.xing.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xing.entity.User;
import com.xing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("/doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        User user = userService.queryByName(username);
        if (null != user && user.getPassword().equals(password)) {
            StpUtil.login(user.getId());
            return "success";
        }

        return "error";
    }

    @RequestMapping("/oauth2")
    public String oauth2(HttpServletRequest request) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
//        if ("zhang".equals(username) && "123456".equals(password)) {
//            StpUtil.login(10001);
//            return "登录成功";
//        }
        return "登录失败";
    }

    @RequestMapping("/ldap")
    public String ldap(HttpServletRequest request) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
//        if ("zhang".equals(username) && "123456".equals(password)) {
//            StpUtil.login(10001);
//            return "登录成功";
//        }
        return "登录失败";
    }

    @RequestMapping("/logout")
    public String doLogin() {
        StpUtil.logout();
        return "登录失败";
    }


    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }



}
