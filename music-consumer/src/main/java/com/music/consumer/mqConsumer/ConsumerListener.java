package com.music.consumer.mqConsumer;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yhy
 */
@Component
//@RabbitListener(queues = {"music.consumer"})
public class ConsumerListener {
    private Logger logger = LoggerFactory.getLogger(ConsumerListener.class);
//    @RabbitHandler
    public void process(Map msg) {
        logger.info("msg"+ JSON.toJSONString(msg));
    }
    @RabbitListener(queues = {"music.consumer"})
    public void processMsg(String msg) {
        logger.info("msg"+ JSON.toJSONString(msg));
    }
}
