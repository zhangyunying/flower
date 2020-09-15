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
@Table(name = "t_seller")
public class Seller {
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
     * 商家名称
     */
    @Column(name = "seller_name")
    private String sellerName;


}
