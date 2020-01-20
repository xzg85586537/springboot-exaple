package com.cn.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @Classname Server
 * @Description
 * @Date 2020/1/8 14:43
 * @Created by xiao
 * 客户端连接
 */
@Configuration
public class Client {
    @Value("${mqtt.url}")
    private String URL;
    @Value("${mqtt.topic}")
    private String TOPIC;
    @Value("${mqtt.username}")
    private String USERNAME;
    @Value("${mqtt.password}")
    private String PASSWORD;

    public void connetct() {
        try {
            /**
             * MqttClient client = new MqttClient(String serverURI, String clientId, MqttClientPersistence persistence)
             * serverURI：一般为tcp协议。
             * clientId：客户端Id，这里采用uuid。
             */
            MqttClient client = new MqttClient(URL, UUID.randomUUID().toString().replaceAll("-", "").toLowerCase(), new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            //MQTT服务器持久化客户端会话的主体订阅和ACK位置
            options.setCleanSession(true);
            options.setUserName(USERNAME);
            options.setPassword(PASSWORD.toCharArray());
            //连接超时时间，秒为单位，默认30秒
            options.setConnectionTimeout(10);
            //定义客户端传来消息的最大时间间隔秒数
            options.setKeepAliveInterval(50);
            MqttTopic topic = client.getTopic(TOPIC);
            //设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息
            options.setWill(topic, "close".getBytes(), 2, true);
            client.connect(options);
            int[] Qos = {1};
            String[] topics = {TOPIC};
            //客户端订阅topic
            client.subscribe(topics, Qos);
            /**
             * 这里可能会有部分案例是进行回调方法，虽然也可以，但是的话MqttReceiveConfig中的handler方法需要删掉
             * 并且回调方法是属于eclipse paho mqtt，而目前我们使用springboot和mqtt进行整合，因此不再需要了
             * client.setCallback(new Callback());
             */
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
