package com.cc.cloud.configuration;

import com.cc.cloud.enums.ExchangeEnum;
import com.cc.cloud.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：DirectQueueConfiguration<br>
 * 类描述：<br>
 * 创建时间：2018年05月11日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Configuration
public class DirectQueueConfiguration {

    /**
     * 配置路由交换对象实例
     * @return
     */
    @Bean
    public DirectExchange directQueueConfiguration(){
        return new DirectExchange(ExchangeEnum.USER_REGISTER.getValue());
    }

    /**
     * 配置队列对象实例
     * @return
     */
    @Bean
    public Queue directExchangeQueue()
    {
        return new Queue(QueueEnum.USER_REGISTER.getName(),true);
    }

    /**
     * 队列绑定到路由交换配置上并设置指定路由键进行转发
     * @return
     */
    @Bean
    public Binding  directExchangeBinding(){
        return BindingBuilder.bind(directExchangeQueue()).to(directQueueConfiguration()).with(QueueEnum.USER_REGISTER.getRoutingKey());
    }
}
