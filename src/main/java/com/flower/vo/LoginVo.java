package com.flower.vo;

import com.flower.enums.LoginType;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author 淮南
 *  登录请求参数VO
 * @since 2020/7/23
 */
@Data
@Accessors(chain = true)
public class LoginVo {
    /**手机号*/
    private String phone;
    /**密码*/
    private String password;
    /**注册类型    MERCHANT("商家"),CONSUMER("消费者"),DELIVERY_MAN("送货员") 传递英文*/
    private LoginType loginType;
}
