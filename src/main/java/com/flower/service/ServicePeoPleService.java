package com.flower.service;

import com.flower.entity.ServiceOrder;
import com.flower.entity.ServicePeople;
import com.flower.vo.ServiceOrderVo;

import java.util.List;

public interface ServicePeoPleService {
    List<ServicePeople> list(String keyword);

    List<ServiceOrderVo> orderList(ServiceOrderVo serviceOrderVo);

    void addPeopel (ServicePeople servicePeople);
}
