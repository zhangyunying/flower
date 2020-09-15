package com.flower.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 淮南
 * @date 2020/7/27 23:04
 */
@Data
@Entity
@Table(name = "t_service_order_comment")
public class ServiceOrderComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * id
     */
    private int id;

    /**
     * 商品id（鲜花id）
     */
    @Column(name = "flower_id")
    private int flowerId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private int orderId;

    /**
     * 所购买的鲜花评价内容
     */
    @Column(name = "comment_info")
    private String commentInfo;

    /**
     * 是否匿名
     */
    private boolean anonymous;

    /**
     * 评价星级
     */
    private String level;

    /**
     * 评价时间
     */
    @Column(name = "comment_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;

}
