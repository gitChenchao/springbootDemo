package com.cc.cloud.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 类名称：DirectExchangeListener<br>
 * 类描述：<br>
 * 创建时间：2018年05月11日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Component
@RabbitListener(queues = "user.register.queue")
public class DirectExchangeListener {
    @RabbitHandler
    public void execute(Long userId) {
        System.out.println("用户：" + userId + "，完成了注册");
    }
}
