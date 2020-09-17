package com.flower.service.impl;

import com.flower.entity.Address;
import com.flower.entity.ServiceOrder;
import com.flower.entity.ServicePeople;
import com.flower.repository.*;
import com.flower.service.ServiceOrderService;
import com.flower.vo.ServiceOrderVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 淮南
 * @date 2020/9/17 15:12
 */

@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ServiceSkillsRepository serviceSkillsRepository;

    @Autowired
    private ServicePeoPleRepository servicePeoPleRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void add(ServiceOrder serviceOrder) {
        serviceOrderRepository.save(serviceOrder);
    }

    @Override
    public List<ServiceOrderVo> orderlist(ServiceOrderVo serviceOrderVo) {
        List<ServiceOrderVo> list = new ArrayList<>();
        List<ServiceOrder> serviceOrderList = serviceOrderRepository.findAll();
        for (ServiceOrder order : serviceOrderList){
            ServiceOrderVo serviceOrderVo1 = new ServiceOrderVo();
            int skillId = order.getSkillId();
            System.out.println("++++_————————"+serviceSkillsRepository.findByServiceId(skillId));
            int serviceId = serviceSkillsRepository.findByServiceId(skillId);
            com.flower.entity.Service service = serviceRepository.findAllByServiceId(serviceId);
            int servicePeopleId = serviceSkillsRepository.findByServicePeopleId(skillId);
            ServicePeople servicePeople = servicePeoPleRepository.findById(servicePeopleId).get();
            int addressId = order.getAddressId();
            Address address = addressRepository.findById(addressId).get();

            serviceOrderVo1.setServiceOrderStatus(order.getServiceOrderStatus());
            serviceOrderVo1.setServiceName(servicePeople.getServicePeopleName());
            serviceOrderVo1.setServiceNum(service.getServiceNum());
            serviceOrderVo1.setAddress(address.getAddress());
            serviceOrderVo1.setName(address.getConsignee());
            serviceOrderVo1.setPhone(address.getReservedPhone());
            serviceOrderVo1.setPrice(String.valueOf(service.getServicePrice()));
            serviceOrderVo1.setRemark(order.getServiceOrderInfo());
            list.add(serviceOrderVo1);
        }
        return list;
    }
}
