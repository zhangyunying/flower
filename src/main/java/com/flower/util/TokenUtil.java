package com.flower.util;

import cn.hutool.crypto.SecureUtil;


/**
 * @author 淮南
 * token工具类
 */
public class TokenUtil {


    /**
     * 生成token
     * @return 返回token
     */
    public static String generateToken(String str) {
        return SecureUtil.md5(str);
    }

}
