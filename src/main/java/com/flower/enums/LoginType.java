package com.flower.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum  LoginType {


    /**
     * 登录用户类型
     */
    MERCHANT("商家"),
    CONSUMER("消费者"),
    DELIVERY_MAN("送货员");

    private final String LOGIN_TYPE;
}
