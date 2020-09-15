package com.flower.service.impl;

import com.flower.entity.Comment;
import com.flower.repository.CommentRepository;
import com.flower.service.CommentService;
import com.flower.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Comment> list(CommentVo commentVo) {
        return commentRepository.findByFlowerId(commentVo.getFlowerId());
    }

    @Override
    public void delete(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public void saveOrUpdate(Comment comment) {
        commentRepository.save(comment);
    }
}
