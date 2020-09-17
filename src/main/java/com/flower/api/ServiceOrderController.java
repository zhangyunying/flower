package com.flower.api;

import com.flower.entity.ServiceOrder;
import com.flower.reponse.Result;
import com.flower.service.ServiceOrderService;
import com.flower.vo.ServiceOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 淮南
 * @date 2020/9/17 15:07
 */

@RestController
@RequestMapping("/serviceOrder")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    /**
     * 服务订单添加
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestBody ServiceOrder serviceOrder){
        serviceOrderService.add(serviceOrder);
        return Result.OK.data(serviceOrder);
    }

    /**
     * 服务订单列表
     * @return
     */
    @RequestMapping("/list")
    public String list(ServiceOrderVo serviceOrderVo){
        List<ServiceOrderVo> list = serviceOrderService.orderlist(serviceOrderVo);
        return Result.OK.data(list);
    }
}
