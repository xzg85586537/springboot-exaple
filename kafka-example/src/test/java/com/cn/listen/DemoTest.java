package com.cn.listen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author by xiao
 * @Classname DemoTest
 * @Description
 * @Date 2020/1/10 11:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
    @Autowired
    private KafkaTemplate template;

    @Test
    public void test() throws InterruptedException {
        template.send("topic.quick.demo", "kafka发送的第一条信息");
        Thread.sleep(5000);
    }
}
