package com.music.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.music.consumer.mqConsumer.ConfirmListenerImpl;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * @author yhy
 */
@RestController
public class MqController {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.6.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setConnectionTimeout(2000);
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.confirmSelect();
        Map<String, Object> map = new HashMap();
        map.put("yang", "123");
        map.put("hao", "789");
        channel.basicPublish("musicExchange", "musicRouting", null, JSON.toJSONString(map).getBytes());
//        添加一个确认监听
        channel.addConfirmListener(new ConfirmListenerImpl());
    }

}
