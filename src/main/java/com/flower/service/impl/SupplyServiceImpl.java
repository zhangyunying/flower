package com.flower.service.impl;

import com.flower.entity.Flower;
import com.flower.entity.Seller;
import com.flower.entity.Supply;
import com.flower.repository.SellerRepository;
import com.flower.repository.SupplyRepository;
import com.flower.service.FlowerService;
import com.flower.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 淮南
 * @date 2020/8/28 14:12
 */

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    SupplyRepository supplyRepository;

    @Autowired
    FlowerService flowerService;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Flower findFlowerBySupplyId(int supplyId) {
        Supply s  = supplyRepository.findBySupplyId(supplyId);
        Flower flower =flowerService.findById(s.getFlowerId());
        return flower;
    }

    @Override
    public String findSellerBySupplyId(int supplyId) {
        Supply s = supplyRepository.findBySupplyId(supplyId);
        return sellerRepository.findSellerNameByUserId(s.getUserId());
    }

    @Override
    public void save(Supply supply) {
        supplyRepository.save(supply);
    }
}
