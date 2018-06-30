package com.cc.cloud.service;

import com.cc.cloud.vo.Company;

/**
 * 类名称：IMessageProvider<br>
 * 类描述：<br>
 * 创建时间：2018年05月08日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface IMessageProvider {
    /**
     * 实现消息的发送，本次发送的消息是一个对象（自动变为json）
     * @param company VO对象，该对象不为null*/
    public void send(Company company) ;
}
