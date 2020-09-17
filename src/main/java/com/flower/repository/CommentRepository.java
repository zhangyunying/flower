package com.flower.repository;

import com.flower.entity.Comment;
import com.flower.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

    List<Comment> findByFlowerId(Integer flowerId);

    List<Comment> findByDynamicId(Integer dynamicId);

}
