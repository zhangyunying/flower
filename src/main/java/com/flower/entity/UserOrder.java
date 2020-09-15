package com.flower.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * 鲜花信息
 * @author 淮南
 */
@Data
@Entity
@Table(name = "t_user_order")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 订单号
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 用户id（消费者）
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 是否自取
     */
    @Column(name = "is_take")
    private boolean isTake;

    /**
     * 购物车id
     */
    @Column(name = "cart_id")
    private int cartId;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    /**
     * 订单备注
     */
    @Column(name = "order_info")
    private String orderInfo;

    /**
     * 订单金额
     */
    @Column(name = "order_price")
    private double orderPrice;

    /**
     * 收货地址id
     */
    @Column(name = "address_id")
    private int addressId;

    /**
     * 是否付款
     */
    @Column(name = "is_pay")
    private boolean isPay;

    /**
     * 预约时间
     */
    @Column(name = "appointment_time")
    private Date appointmentTime;

    /**
     * 供应id
     */
    @Column(name = "supply_Id")
    private int supplyId;

}
