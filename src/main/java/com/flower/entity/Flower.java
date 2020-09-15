package com.flower.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * 鲜花信息
 * @author 淮南
 */
@Data
@Entity
@Table(name = "t_flower")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 鲜花id
     */
    @Column(name = "flower_id")
    private int flowerId;

    /**
     * 鲜花名字（商品标题）
     */
    @Column(name = "flower_name")
    private String flowerName;

    /**
     * 鲜花用途分类
     */
    @Column(name = "flower_type")
    private String flowerType;

    /**
     * 花卉图片
     */
    @Column(name = "flower_img")
    private String flowerImg;

    /**
     * 现价
     */
    @Column(name = "sell_price")
    private double sellPrice;

    /**
     * 原价
     */
    @Column(name = "old_price")
    private double oldPrice;

    /**
     * 花语
     */
    @Column(name = "flower_language")
    private String flowerLanguage;

    /**
     * 鲜花简介
     */
    @Column(name = "flower_info")
    private String flowerInfo;

    /**
     * 适宜人群
     */
    @Column(name = "suitable_for")
    private String suitableFor;
}
