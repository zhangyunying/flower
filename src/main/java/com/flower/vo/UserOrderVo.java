package com.flower.vo;

import com.flower.entity.Flower;
import lombok.Data;

@Data
public class UserOrderVo {

    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 用户id（消费者）
     */
    private Integer userId;

    /**
     * 购物车id
     */
    private Integer cartId;

    /**
     * 下单时间
     */
    private String orderTimeStr;

    /**
     * 订单备注
     */
    private String orderInfo;

    /**
     * 订单金额
     */
    private Double orderPrice;

    /**
     * 收货地址
     */
    private int addressId;

    /**
     * 付款方式
     */
    private boolean isPay;

    /**
     * 联系电话
     */
    private String appointmentTime;

    /**
     * 是否自取
     */
    private boolean isTake;

    /**
     * 供应id
     */
    private int supplyId;

    private Flower flower;
}
