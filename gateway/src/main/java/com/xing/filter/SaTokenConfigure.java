package com.xing.filter;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SaTokenConfigure {



    // 注册 Sa-Token全局过滤器
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        //除web/login,auth/** 全部拦截
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")    /* 拦截全部path */
                // 开放地址
                .addExclude("/favicon.ico")
                .addExclude("/web/login")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                    SaRouter.match("/**", "/auth/**", r -> StpUtil.checkLogin());

                    SaRouter.match("/web/**", r -> StpUtil.checkLogin());
                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/product/list", r -> StpUtil.checkRole("USER"));
                    SaRouter.match("/product/insert", r -> StpUtil.checkRole("EDITOR"));
                    SaRouter.match("/product/delete", r -> StpUtil.checkRole("EDITOR"));
                    SaRouter.match("/product/update", r -> StpUtil.checkRole("EDITOR"));

                    // 更多匹配 ...  */
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    e.printStackTrace();
                    return SaResult.error(e.getMessage());
                });
    }
}
