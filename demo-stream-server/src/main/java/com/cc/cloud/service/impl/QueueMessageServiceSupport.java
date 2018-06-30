package com.cc.cloud.service.impl;

import com.cc.cloud.enums.ExchangeEnum;
import com.cc.cloud.enums.QueueEnum;
import com.cc.cloud.service.QueueMessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 类名称：QueueMessageServiceSupport<br>
 * 类描述：<br>
 * 创建时间：2018年05月11日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Component
public class QueueMessageServiceSupport implements QueueMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息发送方法
     * @param message 消息内容
     * @param exchangeEnum 交换配置枚举
     * @param queueEnum 队列配置枚举
     */
    @Override
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum){
        //设置回调当前对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调Id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息到消息队列
        rabbitTemplate.convertAndSend(exchangeEnum.getValue(),queueEnum.getRoutingKey(),message,correlationId);
    }

    /**
     * 消息回调方法
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause){
        System.out.println("回调Id: "+correlationData.getId());
        if(ack){
            System.out.println("消息发送成功");
        }else {
            System.out.println("消息发送失败:"+cause);
        }
    }
}
