package com.flower.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Result implements Relay<String>{


    /**成功*/
    OK("200","成功"),

    /**失败*/
    FAIL("500","失败"),

    /**认证失败*/
    AUTH_FAIL("403","未登录"),

    /**弹框*/
    ALERT("0000","自定义弹框消息");

    private final String code;
    private final String msg;

}
