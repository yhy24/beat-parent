package com.music.pay;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yhy
 */
@SpringBootApplication
@EnableRabbit
public class MusicPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicPayApplication.class, args);
    }

}
