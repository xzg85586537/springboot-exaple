package com.cn.config;

import com.cn.handler.AuthLimitHandler;
import com.cn.handler.LoginExpireHandler;
import com.cn.handler.LoginFailedHandler;
import com.cn.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname SecurityConfig
 * @Description
 * @Date 2020/3/3 16:04
 * @Author by xiao
 * 前后端分离，异步登录
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //添加跨域共享及csrf
        http.cors().and().csrf().disable();
        //开启授权认证
        http.authorizeRequests().anyRequest().authenticated();
        //配置登录参数和api接口
        http.formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");
        //登录成功调用回调方法
        http.formLogin().successHandler(new LoginSuccessHandler());
        http.formLogin().failureHandler(new LoginFailedHandler());
        /* 登录过期/未登录 处理 */
        http.exceptionHandling().authenticationEntryPoint(new LoginExpireHandler());
        /* 权限不足(没有赋予角色) 处理 */
        http.exceptionHandling().accessDeniedHandler(new AuthLimitHandler());
    }

    /**
     * 跨域配置
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
