package com.flower.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * 鲜花信息
 * @author 淮南
 */
@Data
@Entity
@Table(name = "t_user")
@Accessors(chain = true)
public class User {

    /**
     * 用户id
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 上次登陆时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_load_time")
    private Date lastLoadTime;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户头像
     */
    @Column(name = "user_url")
    private String userUrl;
}
