package com.flower.service.impl;

import com.flower.entity.User;
import com.flower.enums.LoginType;
import com.flower.repository.UserRepository;
import com.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 淮南
 * 用户服务层
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    /**
     * 通过手机号和登录类型查询用户信息
     * @param phone 手机号
     * @param loginType 登录类型
     * @return 返回用户
     */
    @Override
    public User findByPhoneAndLoginType(String phone, String loginType) {
        return userRepository.findByPhoneAndUserType(phone,loginType);
    }

    /**
     * 添加用户
     * @param user 用户信息
     */
    @Override
    public void insert(User user) {
        userRepository.save(user);
    }


    /**
     * 修改用户
     * @param user 用户信息
     */
    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}
