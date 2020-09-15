package com.flower.service;


import com.flower.entity.User;

public interface UserService {

    /**
     * 通过手机号和登录类型查询用户信息
     * @param phone 手机号
     * @param loginType 登录类型
     * @return 返回用户
     */
    User findByPhoneAndLoginType(String phone, String loginType);

    /**
     * 添加用户
     * @param user 用户信息
     */
    void insert(User user);

    /**
     * 修改用户
     * @param user 用户信息
     */
    void update(User user);
}
