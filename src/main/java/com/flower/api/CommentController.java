package com.flower.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.flower.entity.Comment;
import com.flower.entity.Dynamic;
import com.flower.entity.User;
import com.flower.enums.LoginType;
import com.flower.reponse.Result;
import com.flower.service.CommentService;
import com.flower.service.UserService;
import com.flower.util.TokenUtil;
import com.flower.vo.CommentVo;
import com.flower.vo.DynamicVo;
import com.flower.vo.LoginVo;
import com.flower.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    /**
     * 动态信息获取
     * @param commentVo 动态信息获取
     * @return 返回登录结果
     */
    @RequestMapping(value = "/list")
    public String list(@RequestBody CommentVo commentVo) {

        if (commentVo.getFlowerId() == null) {
            return Result.ALERT.alert("鲜花id不可以为空");
        }
        List<Comment> commentList = commentService.list(commentVo);
        return Result.OK.data(commentList);
    }


    /**
     * 评论删除
     * @param commentVo 评论删除
     * @return 返回评论
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestBody CommentVo commentVo) {
        if (commentVo.getCommentId() == null) {
            return Result.ALERT.alert("id不可以为空");
        }
        commentService.delete(commentVo.getCommentId());
        return Result.OK.str();
    }

    /**
     * 发布评论
     * @param commentVo 评论信息
     * @return 返回结果
     */
    @RequestMapping(value = "/saveOrUpdate")
    public String saveOrUpdate(@RequestBody CommentVo commentVo) {

        Comment comment = new Comment();
        BeanUtil.copyProperties(commentVo, comment);
        comment.setCommentTime(new Date());
        commentService.saveOrUpdate(comment);

        return Result.OK.str();
    }


}
