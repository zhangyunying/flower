package com.flower.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 淮南
 * @date 2020/7/27 23:04
 */
@Data
@Entity
@Table(name = "t_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 收货地址id
     */
    @Column(name = "address_id")
    private int addressId;

    /**
     * 签收人
     */
    private String consignee;

    /**
     * 收货电话
     */
    @Column(name = "reserved_phone")
    private String reservedPhone;

    /**
     * 地址
     */
    private String address;


}
