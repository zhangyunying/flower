package com.flower.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.flower.entity.User;
import com.flower.enums.LoginType;
import com.flower.reponse.Result;
import com.flower.service.UserService;
import com.flower.util.TokenUtil;
import com.flower.vo.LoginVo;
import com.flower.vo.RegisterVo;
import com.flower.vo.UserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

@RequestMapping("/user")
@RestController
public class UserController {

    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     *
     * @param loginVo 登录请求参数VO
     * @return 返回登录结果
     */
    @RequestMapping(value = "/login")
    public String login(@RequestBody LoginVo loginVo, HttpServletRequest request) {

        //获取和校验请求参数
        LoginType loginType = loginVo.getLoginType();
        String phone = loginVo.getPhone();
        String password = loginVo.getPassword();
        //存在空值 返回错误
        if (StrUtil.hasBlank(phone, password) || Objects.isNull(loginType)) {
            return Result.FAIL.str();
        }
        //查询用户信息
        User userInfo = userService.findByPhoneAndLoginType(phone, loginType.name());
        //判断是否是否存在  账号密码是否一致
        if (userInfo == null || !password.equals(userInfo.getPassword())) {
            return Result.FAIL.str();
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId", userInfo.getUserId());
        //存在生成token
        String token = TokenUtil.generateToken(phone);
        return Result.OK.data(JSONUtil.createObj().putOpt("token", token).putOpt("userId", userInfo.getUserId()));
    }

    /**
     * 注册接口
     *
     * @param registerVo 注册请求参数
     * @return 返回修改结果
     */
    @RequestMapping(value = "/register")
    public String register(@RequestBody RegisterVo registerVo) {

        //获取和校验请求参数
        LoginType loginType = registerVo.getLoginType();
        String phone = registerVo.getPhone();
        String password = registerVo.getPassword();
        String confirmPassword = registerVo.getConfirmPassword();
        //存在空值 返回错误
        if (StrUtil.hasBlank(phone, password, confirmPassword) || Objects.isNull(loginType)) {
            return Result.FAIL.str();
        }
        if (!password.equals(confirmPassword)) {
            return Result.ALERT.alert("密码输入不一致");
        }
        //查询用户信息
        User userInfo = userService.findByPhoneAndLoginType(phone, loginType.name());
        //判断用户是否已经注册
        if (userInfo != null) {
            return Result.ALERT.alert("用户已存在,请直接登录");
        }
        User user = new User().setUserType(loginType.name()).setLastLoadTime(new Date()).setPassword(password).setPhone(phone);
        userService.insert(user);
        return Result.OK.str();
    }

    /**
     * 修改密码
     *
     * @param registerVo 修改密码参数
     * @return 返回修改结果
     */
    @RequestMapping(value = "/updatePassword")
    public String updatePassword(@RequestBody RegisterVo registerVo) {

        //获取和校验请求参数
        LoginType loginType = registerVo.getLoginType();
        String phone = registerVo.getPhone();
        String password = registerVo.getPassword();
        String confirmPassword = registerVo.getConfirmPassword();

        //存在空值 返回错误
        if (StrUtil.hasBlank(phone, password, confirmPassword) || Objects.isNull(loginType)) {
            return Result.FAIL.str();
        }
        if (!password.equals(confirmPassword)) {
            return Result.ALERT.alert("密码输入不一致");
        }
        //查询用户信息
        User userInfo = userService.findByPhoneAndLoginType(phone, loginType.name());
        //判断用户是否已经注册
        if (userInfo == null) {
            return Result.ALERT.alert("用户不存在,请先注册");
        }
        //验证密码是否一致
        if (!userInfo.getPassword().equals(password)) {
            return Result.ALERT.alert("用户名或密码不正确");
        }
        User user = userInfo.setPassword(password).setPhone(phone);
        userService.update(user);
        return Result.OK.str();
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(@RequestBody UserInfoVo userInfoVo ) {

        //获取和校验请求参数
        LoginType loginType = userInfoVo.getLoginType();
        String phone = userInfoVo.getPhone();
        User u = userService.findByPhoneAndLoginType(phone, String.valueOf(loginType));
        System.out.println("打印user的信息" + u);
        logger.debug("打印user的信息" + u);
//        修改头像
        u.setUserUrl(userInfoVo.getUserUrl());
        u.setNickName(userInfoVo.getNickName());

        userService.update(u);
        return Result.OK.data(JSONUtil.createObj().putOpt("user", u));
    }

}
