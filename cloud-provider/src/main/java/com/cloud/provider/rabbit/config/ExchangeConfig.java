package com.cloud.provider.rabbit.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created with IntelliJ IDEA.
 * @Description: 消息交换机配置  可以配置多个
 * @Author: luhk
 * @Date: 2018-11-29
 * @Time: 5:07 PM
 * @Version: 1.0
 */
@Configuration
public class ExchangeConfig {

    //发布/订阅模式交换机
    public static final  String FANOUT_EXCHANGE = "FANOUT_EXCHANGE";

    //路由模式交换机
    public static final String DIRECT_EXCHANGE = "DIRECT_EXCHANGE";

    //主题模式交换机
    public static final String TOPIC_EXCHANGE = "TOPIC_EXCHANGE";

    /**
     *   1.定义direct fanout，绑定FANOUT_QUEUE
     *   2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   3.fanout交换器相对来说比较简单，匹配规则为：生产者将消息交给交换机，有交换机根据发布订阅的模式设定将消息同步到所有的绑定队列中
     *   消息将会转发给queue参数指定的消息队列
     *   应用场景:邮件群发,群聊天,广告
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        FanoutExchange fanoutExchange = new FanoutExchange(FANOUT_EXCHANGE,false,false);
        return fanoutExchange;
    }

    /**
     *   1.定义direct exchange，绑定DIRECT_QUEUE
     *   2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   3.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *   消息将会转发给queue参数指定的消息队列
     *   应用场景: 项目中的error报错
     */
    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange(DIRECT_EXCHANGE,false,false);
        return directExchange;
    }

    /**
     *   1.定义topic exchange，绑定TOPIC_QUEUE
     *   2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   3.topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     *   消息将会转发给queue参数指定的消息队列
     */
    @Bean
    public TopicExchange topicExchange(){
        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE,false,false);
        return topicExchange;
    }

}
