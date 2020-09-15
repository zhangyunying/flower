package com.flower.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * 鲜花信息
 * @author 淮南
 */
@Data
@Entity
@Table(name = "t_supply")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_id")
    private int supplyId;

    /**
     * 用户id(商家)
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * 鲜花id
     */
    @Column(name = "flower_id")
    private int flowerId;

}
