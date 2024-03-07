package com.xing.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xing.dao.UserRoleMapper;
import com.xing.entity.User;
import com.xing.entity.UserRole;
import com.xing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleMapper userRoleMapper;

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
    public String oauth2(@RequestParam("code") String code) throws IOException {
        if (ObjectUtils.isEmpty(code)) {
            return "error";
        }
        // 创建请求体参数
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", "0a870bbe4d4153b01d43");
        params.add("client_secret", "8bd9aee1aafccdb97abb34b9875b3f19dc5f19ca");
        params.add("code", code);

        // 设置HTTP Headers
        HttpHeaders headers = new HttpHeaders();

        // 创建请求实体
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);

        // 使用RestTemplate发起POST请求
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> resp = restTemplate.postForObject("https://github.com/login/oauth/access_token", requestEntity, HashMap.class);

        // 假设响应体是一个查询字符串形式的access_token等字段，例如："access_token=xxxx&scope=..."
        String accessToken = resp.get("access_token");

        String apiUrl = "https://api.github.com/user";
        headers.set("Authorization", "token " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<HashMap> responseUser = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, HashMap.class);

        HashMap body = responseUser.getBody();

        String username = (String) body.get("login");

        User user = userService.queryByName(username);

        if (ObjectUtils.isEmpty(user)) {
            user = new User();
            user.setName(username);
            user.setPassword(username);
            userService.insert(user);

            user = userService.queryByName(username);

            UserRole userRole = new UserRole();
            userRole.setRole("EDITOR");
            userRole.setUserId(user.getId());
            userRoleMapper.insert(userRole);
        }
        System.out.println("user.getId() = " + user.getId());
        StpUtil.login(user.getId());
        System.out.println("body = " + body);

        return "success";

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
        if (StpUtil.isLogin()) {
            StpUtil.logout();
        }
        return "success";
    }


    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }


}
