package com.flower.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommentVo implements Serializable {

    private Integer flowerId;


    private Integer commentId;
    /**
     * 用户id
     */
    private int userId;

    /**
     * 回复用户的id
     */
    private int replyUserId;

    /**
     * 动态id
     */
    private int dynamicId;

    /**
     * 评论内容
     */
    private String commentMsg;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;
}
