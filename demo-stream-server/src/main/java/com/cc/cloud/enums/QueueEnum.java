package com.cc.cloud.enums;

import lombok.Getter;

/**
 * 类名称：QueueEnum<br>
 * 类描述：<br>
 * 创建时间：2018年05月11日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Getter
public enum QueueEnum {
    /** * 用户注册枚举 */
    USER_REGISTER("user.register.queue","user.register");
    /** * 队列名称 */
    private String name;
    /** * 队列路由键 */
    private String routingKey;
    QueueEnum(String name, String routingKey) {
        this.name = name; this.routingKey = routingKey;
    }
}
