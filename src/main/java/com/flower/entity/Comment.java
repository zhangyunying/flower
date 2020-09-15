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
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    /**
     * 评论id
     */
    private int commentId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private int userId;

    /**
     * 鲜花id
     */
    @Column(name = "flower_id")
    private int flowerId;
    /**
     * 回复用户的id
     */
    @Column(name = "reply_user_id")
    private int replyUserId;

    /**
     * 动态id
     */
    @Column(name = "dynamic_id")
    private int dynamicId;

    /**
     * 评论内容
     */
    @Column(name = "comment_msg")
    private String commentMsg;

    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;
}
