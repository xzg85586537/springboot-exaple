package com.cn.server;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.UUID;

/**
 * @Classname MqttSendConfig
 * @Description
 * @Date 2020/1/8 14:40
 * @Created by xiao
 * 服务端发送消息
 */

@Configuration
@IntegrationComponentScan
public class MqttSendConfig {
    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.url}")
    private String hostUrl;

    @Value("${mqtt.topic}")
    private String topic;

    @Value("${mqtt.completionTimeout}")
    private int completionTimeout;

    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        //是否清除session
        mqttConnectOptions.setCleanSession(false);
        // 设置超时时间
        mqttConnectOptions.setConnectionTimeout(completionTimeout);
        // 设置会话心跳时间
        mqttConnectOptions.setKeepAliveInterval(20);
        return mqttConnectOptions;
    }

    /**
     * 客户端工厂类：包含用户名、密码等等配置
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }


    /**
     * 发送通道
     * @return
     */
    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    /**
     * 通过通道发送数据
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        //MqttPahoMessageHandler：MQTT出站通道适配器的抽象类的实现,用于推送消息。
        MqttPahoMessageHandler mqttPahoMessageHandler = new MqttPahoMessageHandler(UUID.randomUUID().toString().replace("-", "").toLowerCase(), mqttClientFactory());
        mqttPahoMessageHandler.setAsync(true);
        mqttPahoMessageHandler.setDefaultTopic(topic);
        return mqttPahoMessageHandler;
    }
}
