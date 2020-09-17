package com.flower.service;

import com.flower.entity.Flower;
import com.flower.entity.Seller;
import com.flower.entity.Supply;

import java.util.List;

/**
 * @author 淮南
 * @date 2020/8/28 14:10
 */
public interface SupplyService {

    /**
     * 根据供应id查找鲜花id及相应鲜花信息
     */
    Flower findFlowerBySupplyId(int supplyId);

    /**
     * 根据供应id查找商家信息
     */
    String findSellerBySupplyId(int supplyId);

    void save(Supply supply);

    Supply findSupplyId(int supplyId);

}
