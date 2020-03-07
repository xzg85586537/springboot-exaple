package com.cn.config;

import com.cn.service.MyUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @Classname AuthServerConfig
 * @Description
 * @Date 2020/3/3 19:52
 * @Author by xiao
 * 授权服务
 */
@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 可能会报无法注入的问题，在SecurityConfig配置类中重新实例化authenticationManagerBean这个Bean即可。
     */
    private AuthenticationManager authenticationManager;
    private RedisConnectionFactory redisConnectionFactory;
    private WebResponseExceptionTranslator webResponseExceptionTranslator;
    private DataSource dataSource;
    /**
     * 注入userDetailsService，开启refresh_token需要用到
     */
    private MyUserDetailService userDetailService;

    /**
     * 将token存储到redis中
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许所有人请求令牌
        security.tokenKeyAccess("permitAll()")
                //已验证的客户端才能请求check_token端点
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 配置客户端，通过授权码方式获取，也可以通过密码方式获取
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
//        clients.inMemory()
//                //客户端id
//                .withClient("clientId")
//                //客户端秘钥
//                .secret(new BCryptPasswordEncoder().encode("secret"))
//                /*
//                客户端选择的授权方式：
//                授权码模式:authorization_code,
//                密码模式:password,
//                刷新token: refresh_token
//                隐式模式: implicit
//                客户端模式: client_credentials
//                多个模式的话用逗号分隔
//                 */
//                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
//                //客户端的权限范围
//                .scopes("all")
//                //默认用户自动同意授权，如果不写默认false
//                .autoApprove(true)
//                //客户端重定向的url
//                .redirectUris("http://localhost:8081/")
//                .and()
//                .withClient("webapp")
//                .scopes("read")
//                .authorizedGrantTypes("authorization_code", "password");
    }


    /**
     * 配置token管理  目前token存储在内存中，后续可以改成redis
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
//                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager)
                //自定义登录或者鉴权失败时的返回信息
                .exceptionTranslator(webResponseExceptionTranslator)
//                .reuseRefreshTokens(false)
//                .tokenServices(defaultTokenServices())
                //要使用refresh_token的话，需要额外配置userDetailsService
                .userDetailsService(userDetailService);
    }

//    /**
//     * 自定义token的管理
//     *
//     * @return
//     */
//    @Bean
//    @Primary
//    public DefaultTokenServices defaultTokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        //token存储地方
//        tokenServices.setTokenStore(tokenStore());
//        tokenServices.setSupportRefreshToken(true);
//        //token有效期 默认12小时
//        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 12);
//        //refresh_token有效期 默认30天
//        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
//        return tokenServices;
//    }


    /**
     * 配置jwt转换器
     */
    private AccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("secret");
        return converter;
    }

}
