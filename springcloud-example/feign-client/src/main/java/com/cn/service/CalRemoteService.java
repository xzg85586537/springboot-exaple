package com.cn.service;

import com.cn.factory.RemoteFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by xiao
 * @Classname CalRemoteService
 * @Description
 * @Date 2020-03-30 0:41
 * 使用feign调用服务或者使用RestTemplate 调用服务均可，但是建议feign调用，节省代码
 * <p>
 * feign整合了ribbon，具有负载均衡的能力；整合了Hystrix，具有熔断的能力
 * fallbackFactory：服务熔断功能
 */

//@FeignClient value,name 这两个就同一个意思:对应的是调用的微服务的服务名。
@FeignClient(name = "feign-server", fallbackFactory = RemoteFactory.class)
public interface CalRemoteService {
    //调用服务的路径及方法
    @RequestMapping(value = "/cal/add")
    public String add(@RequestParam(value = "a") Integer a, @RequestParam("b") Integer b);
}
