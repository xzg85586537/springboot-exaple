package com.cn.server;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.StandardCharsets;


public class Callback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
		System.err.println("connection lost,cause:{}" + cause);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Received Topic:{}"+ topic);
		System.out.println("Received Message QOS:{}"+ message.getQos());
		System.out.println("Received Message ID:{}"+ message.getId());
		System.out.println("Received Message Body:{}"+ new String(message.getPayload(), StandardCharsets.UTF_8));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        try {
			System.out.println("delivery complete,message:{},complete:{}"+ token.getMessage() + token.isComplete());
        } catch (MqttException e) {
			System.err.println(e.getMessage() + e);
        }
    }
}
