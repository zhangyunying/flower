package com.flower.repository;

import com.flower.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

    /**
     * 通过手机号和用户类型查询用户信息
     * @param phone 手机号
     * @param loginType 用户类型
     * @return 返回用户信息
     */
    User findByPhoneAndUserType(String phone, String loginType);
}
