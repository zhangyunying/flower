package com.flower.reponse;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;

import java.util.Collections;

public interface Relay<C> {

    /**常量字段*/
    String CODE = "code";String MSG = "msg";String DATA = "data";
    /**设置字段排序*/
    JSONConfig JSON_CONFIG = JSONConfig.create().setOrder(true);

    /**
     * 获取code
     * @return 返回code
     */
    C getCode();

    /**
     * 获取msg
     * @return 返回msg
     */
    C getMsg();


    /**
     * 不带数据弹框
     * @param msg 弹框消息
     * @return 返回相应结果
     */
    default String alert(String msg) {
        return new JSONObject(5, JSON_CONFIG)
                .putOpt(CODE, getCode())
                .putOpt(MSG, msg)
                .putOpt(DATA, Collections.emptyMap())
                .toString();
    }

    /**
     * 带数据相应结果
     * @param data 数据model
     * @return 返回相应结果
     */
    default <T> String data(T data) {
        return new JSONObject(5, JSON_CONFIG)
                .putOpt(CODE, getCode())
                .putOpt(MSG, getMsg())
                .putOpt(DATA, data)
                .toString();
    }

    /**
     * 返回当前消息
     * @return 返回相应结果
     */
    default  String str() {
        return new JSONObject(5, JSON_CONFIG)
                .putOpt(CODE, getCode())
                .putOpt(MSG, getMsg())
                .putOpt(DATA, Collections.emptyMap())
                .toString();
    }

}
