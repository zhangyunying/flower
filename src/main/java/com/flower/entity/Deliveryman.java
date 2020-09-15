package com.flower.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 淮南
 * @date 2020/7/27 23:04
 */
@Data
@Entity
@Table(name = "t_deliveryman")
public class Deliveryman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * id
     */
    private int id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * 订单状态（已完成，未完成）
     */
    @Column(name = "Order_status")
    private String OrderStatus;


}
