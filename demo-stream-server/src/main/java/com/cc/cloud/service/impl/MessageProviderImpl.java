package com.cc.cloud.service.impl;

import com.cc.cloud.service.IMessageProvider;
import com.cc.cloud.vo.Company;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * 类名称：MessageProviderImpl<br>
 * 类描述：<br>
 * 创建时间：2018年05月08日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public void send(Company company) {
        this.output.send(MessageBuilder.withPayload(company).build());
    }
}
