package com.flower.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DynamicVo implements Serializable{

    /**动态信息id*/
    private Integer dynamicId;
    /**动态图片*/
    private String dynamicImg;
    /**动态消息*/
    private String dynamicMsg;
    /**更新时间*/
    private String updateTimeStr;

    /**发布时间*/
    private String publishTimeStr;
    /**用户id*/
    private String userId;
    /**用户昵称*/
    private String nikeName;
}
