package com.flower.service.impl;

import cn.hutool.core.util.StrUtil;
import com.flower.entity.Address;
import com.flower.entity.ServiceOrder;
import com.flower.entity.ServicePeople;
import com.flower.repository.AddressRepository;
import com.flower.repository.ServiceOrderRepository;
import com.flower.repository.ServicePeoPleRepository;
import com.flower.repository.ServiceRepository;
import com.flower.service.ServicePeoPleService;
import com.flower.vo.ServiceOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServicePeoPleServiceImpl implements ServicePeoPleService {

    @Autowired
    ServicePeoPleRepository servicePeoPleRepository;
    @Autowired
    ServiceOrderRepository serviceOrderRepository;
    @Autowired
     AddressRepository addressRepository;
    @Autowired
     ServiceRepository serviceRepository;

    @Override
    public List<ServicePeople> list(String keyword) {
        if (StrUtil.isNotBlank(keyword)) {
            servicePeoPleRepository.findAll((Specification<ServicePeople>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("servicePeopleName"), "%" + keyword + "%"));
        }
        return servicePeoPleRepository.findAll();
    }

    @Override
    public List<ServiceOrderVo> orderList(ServiceOrderVo serviceOrderVo) {
        String serviceOrderStatus = serviceOrderVo.getServiceOrderStatus();
        Example<ServiceOrder> example  = Example.of(new ServiceOrder().setServiceOrderStatus(serviceOrderStatus));
        List<ServiceOrder> serviceOrderList = serviceOrderRepository.findAll(example);
        List<ServiceOrderVo> list = new ArrayList<>();
        for (ServiceOrder serviceOrder : serviceOrderList) {
            ServiceOrderVo serviceOrderVo1 = new ServiceOrderVo();
            int addressId = serviceOrder.getAddressId();
            int serviceId = serviceOrder.getServiceId();
            Date serviceOrderTime = serviceOrder.getServiceOrderTime();
            int servicePeopleId = serviceOrder.getServicePeopleId();
            ServicePeople servicePeople = servicePeoPleRepository.findById(servicePeopleId).get();
            serviceOrderVo1.setServicePeoPleName(servicePeople.getServicePeopleName());
            serviceOrderVo1.setServiceOrderStatus(serviceOrderStatus);
            Address address = addressRepository.findById(addressId).get();
            serviceOrderVo1.setAddress(address.getAddress());
            serviceOrderVo1.setPhone(address.getReservedPhone());
            serviceOrderVo1.setName(address.getConsignee());
            serviceOrderVo1.setRemark(serviceOrder.getServiceOrderInfo());
            serviceOrderVo1.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(serviceOrderTime));
            com.flower.entity.Service service = serviceRepository.findById(serviceId).get();
            serviceOrderVo1.setServiceName(service.getServiceName());
            serviceOrderVo1.setServiceNum(service.getServiceNum());
            serviceOrderVo1.setPrice(String.valueOf(service.getServicePrice()));
            list.add(serviceOrderVo1);
        }
        return list;
    }


    @Override
    public void addPeopel(com.flower.entity.ServicePeople servicePeople) {
        servicePeoPleRepository.save(servicePeople);
    }
}
