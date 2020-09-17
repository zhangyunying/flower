package com.flower.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceOrderVo implements Serializable{

    /*进行中 退款中 已完成  安状态分类请求参数*/
    private String serviceOrderStatus;
    private String serviceName;
    private Integer serviceNum;
    private String servicePeoPleName;
    private String orderTime;
    private String phone;
    private String address;
//    顾客的名字
    private String name;
    private String price;
//    订单备注
    private String remark;

}
