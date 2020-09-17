package com.flower.service.impl;

import cn.hutool.core.util.StrUtil;
import com.flower.repository.ServiceRepository;
import com.flower.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public List<com.flower.entity.Service> list(String keyword) {
        if (StrUtil.isNotBlank(keyword)) {
            return serviceRepository.findAll((Specification<com.flower.entity.Service>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("serviceName"), "%" + keyword + "%"));
        }
        return serviceRepository.findAll();
    }

    @Override
    public com.flower.entity.Service findOne(String serviceId) {
        return serviceRepository.getOne(Integer.valueOf(serviceId));
    }


    @Override
    public void addService(com.flower.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<com.flower.entity.Service> serviceList() {
        return serviceRepository.findAll();
    }
}
