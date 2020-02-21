package com.cn.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author by xiao
 * @Classname DemoListener
 * @Description
 * @Date 2020/1/10 10:59
 */
@Component
@Slf4j
public class DemoListener {

    //声明consumerID为demo，监听topicName为topic.quick.demo的Topic
    @KafkaListener(id = "demo",topics = "topic.quick.demo")
    public void listen(String msg) {
    log.info("接收的kafka消息为："+msg);
    }
    //第二次提交

}
