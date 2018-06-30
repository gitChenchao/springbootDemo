package com.cc.cloud.service;

import com.cc.cloud.enums.ExchangeEnum;
import com.cc.cloud.enums.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 类名称：QueueMessageService<br>
 * 类描述：<br>
 * 创建时间：2018年05月11日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback {
    /**
     * 发送消息到rabbitmq消息队列
     * @param message 消息内容
     * @param exchangeEnum 交换配置枚举
     * @param queueEnum 队列配置枚举
     * @throws Exception
     */
    void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception;
}
