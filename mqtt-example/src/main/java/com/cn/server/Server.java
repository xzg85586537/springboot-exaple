package com.cn.server;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class Server {

    @Value("${mqtt.url}")
    private String URL;
    @Value("${mqtt.topic}")
    private String TOPIC;
    @Value("${mqtt.username}")
    private String USERNAME;
    @Value("${mqtt.password}")
    private String PASSWORD;

    public void start() {
        try {
            MqttClient client = new MqttClient(URL, UUID.randomUUID().toString().replaceAll("-", "").toLowerCase(), new MemoryPersistence());
            client.setCallback(new Callback());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(USERNAME);
            options.setPassword(PASSWORD.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(50);

            MqttTopic topic = client.getTopic(TOPIC);
            options.setWill(topic, "close".getBytes(), 2, true);

            client.connect(options);

            int[] Qos = {2};
            String[] topics = {TOPIC};
            client.subscribe(topics, Qos);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
