package com.flower.service;

import com.flower.entity.Comment;
import com.flower.vo.CommentVo;

import java.util.List;

public interface CommentService {

    /**查询所有评论*/
    List<Comment> list(int dynamicId);

    /**通过评论id删除评论*/
    void delete(Integer commentId);

    /**发布或者更新评论信息*/
    void saveOrUpdate(Comment comment);
}
