package com.flower.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.flower.entity.Dynamic;
import com.flower.entity.User;
import com.flower.reponse.Result;
import com.flower.repository.UserRepository;
import com.flower.service.DynamicService;
import com.flower.vo.DynamicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RequestMapping("/dynamic")
@RestController
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;
    @Autowired
    private UserRepository userRepository;

    /**
     * 动态信息列表
     * @param dynamicVo 动态信息列表
     * @return 返回登录结果
     */
    @RequestMapping(value = "/list")
    public String list(DynamicVo dynamicVo) {
        List<Dynamic> dynamicList = dynamicService.list(dynamicVo);
        List<DynamicVo> dynamicVoList = new ArrayList<>(dynamicList.size());
        for (Dynamic dynamic : dynamicList) {
            DynamicVo dynamicVo1 = new DynamicVo();
            BeanUtil.copyProperties(dynamic,dynamicVo1 );
            dynamicVo1.setPublishTimeStr(DateUtil.format(dynamic.getPublishTime(), "yyyy-MM-dd HH:mm:ss"));
            dynamicVo1.setUpdateTimeStr(DateUtil.format(dynamic.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
            Optional<User> user = userRepository.findById(dynamic.getUserId());
            dynamicVo1.setNikeName(user.get().getNickName());
            dynamicVoList.add(dynamicVo1);
        }
        return Result.OK.data(dynamicVoList);
    }


    /**
     * 动态信息删除
     * @param dynamicVo 动态信息删除
     * @return 返回登录结果
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestBody DynamicVo dynamicVo) {
        if (dynamicVo.getDynamicId() == null) {
            return Result.ALERT.alert("id不可以为空");
        }
        dynamicService.delete(dynamicVo.getDynamicId());
        return Result.OK.str();
    }

    /**
     * 动态发布和修改
     * @param dynamicVo 动态信息获取
     * @return 返回登录结果
     */
    @RequestMapping(value = "/saveOrUpdate")
    public String saveOrUpdate(@RequestBody DynamicVo dynamicVo) {

        Dynamic dynamic = new Dynamic();
        BeanUtil.copyProperties(dynamicVo, dynamic);
        if (dynamicVo.getDynamicId() != null) {
            dynamic.setUpdateTime(new Date());
        } else {
            dynamic.setPublishTime(new Date());
        }
        dynamicService.saveOrUpdate(dynamic);
        return Result.OK.str();
    }

}
