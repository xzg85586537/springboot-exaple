package com.cn.client;

import com.cn.entity.MqttData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MqttLocalClientTest {

    @Test
    public void test() {
        String topic = "mtopic/geomagnetic/parking/garage/b5502988c75140f6b257595047a12660/06eea5285be74da89e879e897bdea812";
        MqttData<List> data = new MqttData<>();
        data.setKey("key");
        data.setMethod("method");
        List models = new ArrayList();
        models.add("1234");
        models.add("abcd");
        data.setData(models);
        MqttLocalClient.sendToMqtt(data, topic);
    }


}
