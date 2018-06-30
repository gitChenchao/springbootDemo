package com.cc.cloud.enums;

import lombok.Getter;

/**
 * 类名称：ExchangeEnum<br>
 * 类描述：<br>
 * 创建时间：2018年05月11日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Getter
public enum ExchangeEnum {
    /**
     * 用于注册交换配置枚举
     */
    USER_REGISTER("user.register.topic.exchange");
    private String value;
    ExchangeEnum(String value) {
        this.value = value;
    }
}
