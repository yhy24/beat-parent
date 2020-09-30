package com.music.pay.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yhy
 */
@RestController
public class MusicPayController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/pay")
    public String payMusic() {
        return "music pay";
    }

    @RequestMapping("/consumer")
    public String mqProduce() {
        Map<String, Object> message = new HashMap<>();
        String msgId = UUID.randomUUID().toString();
        String msgData = "hello,boy";
        String msgDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        message.put("msgId", msgId);
        message.put("msgData", msgData);
        message.put("msgDate", msgDate);
        rabbitTemplate.convertAndSend("musicExchange", "musicRouting", message);
        return "ok";
    }
}
