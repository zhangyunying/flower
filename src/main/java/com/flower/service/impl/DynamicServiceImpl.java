package com.flower.service.impl;

import com.flower.entity.Dynamic;
import com.flower.repository.DynamicRepository;
import com.flower.service.DynamicService;
import com.flower.vo.DynamicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicRepository dynamicRepository;


    @Override
    public List<Dynamic> list(DynamicVo dynamicVo) {
        if (!Objects.isNull(dynamicVo) && dynamicVo.getDynamicId() != null) {
            dynamicRepository.findById(dynamicVo.getDynamicId());
        }
        return dynamicRepository.findAll();
    }

    @Override
    public void delete(Integer dynamicId) {
        dynamicRepository.deleteById(dynamicId);
    }

    @Override
    public void save(Dynamic dynamic) {
        dynamicRepository.save(dynamic);
    }

    @Override
    public Dynamic findById(int dynamicId) {
        return dynamicRepository.findByDynamicId(dynamicId);
    }
}
