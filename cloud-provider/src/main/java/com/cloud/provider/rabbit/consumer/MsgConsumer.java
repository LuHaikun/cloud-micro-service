package com.cloud.provider.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息接收  消费者
 * @Author: luhk
 * @Date: 2018-11-29
 * @Time: 5:23 PM
 * @Version: 1.0
 */
@Slf4j
@Component
public class MsgConsumer {

    @RabbitHandler
    @RabbitListener(queues = "SIMPLE_QUEUE")
    public void simpleModeProcess(String message) throws Exception {
        // 处理消息
        Thread.sleep(200);
        log.info("simple-queue1 handleMessage :" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "SIMPLE_QUEUE")
    public void workModeProcess(String message) throws Exception {
        // 处理消息
        Thread.sleep(500);
        log.info("simple-queue2 handleMessage :" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "FANOUT_QUEUE")
    public void fanoutModeProcess(String message) throws Exception {
        // 处理消息
        Thread.sleep(200);
        log.info("fanout-queue handleMessage :" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "DIRECT_QUEUE")
    public void directModeProcess(String message) throws Exception {
        // 处理消息
        Thread.sleep(200);
        log.info("direct-queue handleMessage :" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "TOPIC_QUEUE")
    public void topicModeProcess(String message) throws Exception {
        // 处理消息
        Thread.sleep(200);
        log.info("topic-queue handleMessage :" + message);
    }
}
