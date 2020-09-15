package com.flower.service;

import com.flower.entity.Service;

import java.util.List;

public interface ServiceService {
    List<Service> list(String keyword);

    Service findOne(String serviceId);

    void addService(Service service);
}
