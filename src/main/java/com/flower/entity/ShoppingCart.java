package com.flower.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 鲜花信息
 * @author 淮南
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "t_shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 购物车id
     */
    @Column(name = "cart_id")
    private int cartId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * 供应id
     */
    @Column(name = "supply_id")
    private int supplyId;

    /**
     * 数量
     */
    private Integer count;



}
