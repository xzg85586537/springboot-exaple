package com.cn.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 白名单放行的url
 * @Author xiao
 * @Date 2020-10-07 18:21
 * @Version 1.0
 */
@Getter
@Setter
//全路径是secure.ignored.urls，但是这里要写成secure.ignored，然后下面的list写成urls
@ConfigurationProperties(prefix = "secure.ignored")
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

}
