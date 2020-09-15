package com.flower.vo;

import com.flower.enums.LoginType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 淮南
 * @date 2020/8/16 21:38
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {

    /**手机号*/
    private String phone;
    /**注册类型    MERCHANT("商家"),CONSUMER("消费者"),DELIVERY_MAN("送货员") 传递英文*/
    private LoginType loginType;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String userUrl;
}
