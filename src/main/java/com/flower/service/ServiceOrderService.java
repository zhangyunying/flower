package com.flower.service;

import com.flower.entity.ServiceOrder;
import com.flower.vo.ServiceOrderVo;

import java.util.List;

/**
 * @author 淮南
 * @date 2020/9/17 15:11
 */
public interface ServiceOrderService {

    void add(ServiceOrder serviceOrder);

    List<ServiceOrderVo> orderlist(ServiceOrderVo serviceOrderVo);
}
