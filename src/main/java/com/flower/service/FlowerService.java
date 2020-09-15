package com.flower.service;

import com.flower.entity.Flower;
import com.flower.vo.FlowerQueryVo;

import java.util.List;

public interface FlowerService {


    /**根据条件查询所有的鲜花列表*/
    List<Flower> findAll(FlowerQueryVo flowerQueryVo);

    /**通过鲜花id查询鲜花信息*/
    Flower findById(Integer id);

    /**添加或者更新鲜花信息*/
    void addOrUpdate(Flower flower);
}
