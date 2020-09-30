package com.music.consumer.mqConsumer;

import com.rabbitmq.client.ConfirmListener;

import java.io.IOException;

public class ConfirmListenerImpl implements ConfirmListener {
    @Override
    public void handleAck(long l, boolean b) throws IOException {
        System.out.println("---------ack-------------");
    }

    @Override
    public void handleNack(long l, boolean b) throws IOException {
        System.out.println("-------no--ack-------------");
    }
}
