package com.cloud.provider.rabbit.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 消息发送到交换机确认机制
 * @author luhk
 * @date 2018/11/15 15:40
 * @email lhk2014@163.com
 */
@Slf4j
public class SendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息发送成功, 回调id:" + correlationData);
        } else {
            log.info("消息发送失败:, 回调id:" + correlationData + cause + "重新发送");
        }
    }
}
