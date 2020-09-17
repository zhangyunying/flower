package com.flower.service;

import com.flower.entity.Dynamic;
import com.flower.vo.DynamicVo;

import java.util.List;


public interface DynamicService {

    /**查询动态信息列表 或者根据id查询单条*/
    List<Dynamic> list(DynamicVo dynamicVo);

    /**通过id删除动态信息*/
    void delete(Integer dynamicId);

    /**
     * 保存或者更新动态信息 根据是否包含id
     * */
    void save(Dynamic dynamic);

    Dynamic findById(int dynamicId);
}
