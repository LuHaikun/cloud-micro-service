package com.cloud.provider.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 队列配置  可以配置多个
 * @Author: luhk
 * @Date: 2018-11-29
 * @Time: 5:07 PM
 * @Version: 1.0
 */
@Configuration
public class QueueConfig {
    /**
     durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
     auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
     exclusive  表示该消息队列是否只在当前connection生效,默认是false
     */
    //普通模式队列
    public static final String SIMPLE_QUEUE = "SIMPLE_QUEUE";

    //发布订阅模式队列
    public static final String FANOUT_QUEUE = "FANOUT_QUEUE";

    //路由模式队列
    public static final String DIRECT_QUEUE = "DIRECT_QUEUE";

    //主题模式队列
    public static final String TOPIC_QUEUE = "TOPIC_QUEUE";

    @Bean
    public Queue simpleQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-max-length", 1000);
        return new Queue(SIMPLE_QUEUE, false, false, false, arguments);
    }

    @Bean
    public Queue fanoutQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-max-length", 1000);
        return new Queue(FANOUT_QUEUE, false, false, false, arguments);
    }

    @Bean
    public Queue directQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-max-length", 1000);
        return new Queue(DIRECT_QUEUE, false, false, false, arguments);
    }

    @Bean
    public Queue topicQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-max-length", 1000);
        return new Queue(TOPIC_QUEUE, false, false, false, arguments);
    }
}
