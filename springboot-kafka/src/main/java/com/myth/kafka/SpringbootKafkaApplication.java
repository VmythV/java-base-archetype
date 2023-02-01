package com.myth.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class SpringbootKafkaApplication implements CommandLineRunner {

    @Qualifier("kafkaTemplate")
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaApplication.class, args);
    }

    /**
     * 生产消息
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        String topic = "test";
        String message = "111";
        SendResult<String, String> result = null;
        try {
            result = kafkaTemplate.send(topic, message).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("sendMessageSync => topic: {}, key: {}, message: {}", topic, 0, message);
        log.info("The result is: {} ",result);

        log.info("===========================================");

    }

    /**
     * 消费消息
     * @param message 消息体
     */
    @KafkaListener(id = "consumerSingle", topics = "test")
    public void consumerSingle(String message) {
        log.info("consumerSingle ====> message: {}", message);
    }
}
