package com.flower.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 淮南
 * @date 2020/5/5 11:56
 */
@Data
@Entity
@Table(name = "t_dynamic")
public class Dynamic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 动态id
     */
    @Column(name = "dynamic_id")
    private int dynamicId;

    /**
     * 动态发布用户的id
     */
    @Column(name = "user_id")
    private int userId;

    /**
     *动态内容
     */
    @Column(name = "dynamic_msg")
    private String dynamicMsg;

    /**
     * 动态图片
     */
    @Column(name = "dynamic_img")
    private String dynamicImg;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
