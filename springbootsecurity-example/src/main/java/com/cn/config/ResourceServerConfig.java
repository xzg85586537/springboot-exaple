package com.cn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

/**
 * @Classname ResourceServerConfig
 * @Description
 * @Date 2020/3/4 9:59
 * @Author by xiao
 * 资源服务
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 配置资源拦截规则
     * 这里设置需要token验证的url，这些url可以在WebSecurityConfigurerAdapter中排查掉，
     * 对于相同的url，如果二者都配置了验证
     * 则优先进入ResourceServerConfigurerAdapter,进行token验证。而不会进行
     * WebSecurityConfigurerAdapter 的 basic auth或表单认证。
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/hi")
                .and()
                .authorizeRequests()
                .antMatchers("/hi").authenticated();
//        http.csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .requestMatchers()
//                .antMatchers("/api/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/**")
//                .authenticated()
//                .and()
//                .httpBasic();
    }


//    /**
//     配置jwt转换器
//     */
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("secret");
//        return converter;
//    }
}
