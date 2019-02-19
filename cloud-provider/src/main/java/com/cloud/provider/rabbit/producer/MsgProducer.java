package com.cloud.provider.rabbit.producer;

import com.cloud.provider.rabbit.config.ExchangeConfig;
import com.cloud.provider.rabbit.config.QueueConfig;
import com.cloud.provider.rabbit.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息发送  生产者
 * @Author: luhk
 * @Date: 2018-11-29
 * @Time: 5:22 PM
 * @Version: 1.0
 */
@Slf4j
@Component
public class MsgProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息 普通模式
     * @param uuid
     * @param message  消息
     */
    public void simpleModeSend(String uuid,Object message) {
        String context = "您好，我是简单模式消息队列发送器";
        rabbitTemplate.convertAndSend(QueueConfig.SIMPLE_QUEUE, message +"____"+context);
        log.info("简单模式发送器 send :"+ context +"____"+message);
    }

    /**
     * 发送消息 发布/订阅模式队列可接收
     * @param uuid
     * @param message  消息
     */
    public void fanoutModeSend(String uuid,Object message) {
        String context = "您好，我是发布/订阅模式消息队列发送器";
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(ExchangeConfig.FANOUT_EXCHANGE, "",
                context +"____"+ message, correlationId);
        log.info("发布/订阅模式发送器 send :"+ context +"____"+ message);
    }


    /**
     * 发送消息 路由模式队列可以接收
     * @param uuid
     * @param message  消息
     */
    public void directModeSend(String uuid,Object message) {
        String context = "您好，我是路由模式消息队列发送器";
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(ExchangeConfig.DIRECT_EXCHANGE, RabbitMqConfig.DIRECT_ROUTING_KEY,
                context +"____" + message, correlationId);
        log.info("路由模式发送器 send :"+ context +"____"+ message);
    }


    /**
     * 发送消息 主题模式队列1可以接收
     * @param uuid
     * @param message  消息
     */
    public void topicModesend1(String uuid,Object message) {
        String context = "您好，我是主题模式消息队列发送器";
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(ExchangeConfig.TOPIC_EXCHANGE, "topic.xxx",
                context +"____" + message, correlationId);
        log.info("主题模式发送器 send :" + context +"____"+ message);
    }


    /**
     * 发送消息 主题模式队队列1、队列2可以接收
     * @param uuid
     * @param message  消息
     */
    public void topicModesend2(String uuid,Object message) {
        String context = "您好，我是主题模式消息队列发送器";
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(ExchangeConfig.TOPIC_EXCHANGE, RabbitMqConfig.TOPIC_ROUTING_KEY1,
                context +"____" + message, correlationId);
        log.info("主题模式发送器 send :"+ context +"____"+ message);
    }
}
