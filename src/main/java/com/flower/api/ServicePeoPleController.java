package com.flower.api;

import com.flower.entity.Service;
import com.flower.entity.ServiceOrder;
import com.flower.entity.ServicePeople;
import com.flower.reponse.Result;
import com.flower.service.ServicePeoPleService;
import com.flower.service.ServiceService;
import com.flower.vo.ServiceOrderVo;
import com.flower.vo.ServicePeopleVo;
import com.flower.vo.ServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("servicePeople")
public class ServicePeoPleController {

    @Autowired
    private ServicePeoPleService servicePeoPleService;

    /**
     * 服务人员列表/服务人员查询列表
     * @param servicePeopleVo
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestBody ServicePeopleVo servicePeopleVo) {
       List<ServicePeople> serviceList = servicePeoPleService.list(servicePeopleVo.getKeyword());
        return Result.OK.data(serviceList);
    }

    /**
     * 未用
     * 添加服务订单
     */
    @RequestMapping("/orderList")
//    @RequestBody
    public String orderList( ServiceOrderVo serviceOrderVo) {
        List<ServiceOrderVo> serviceList = servicePeoPleService.orderList(serviceOrderVo);
        return Result.OK.data(serviceList);
    }


    /**
     * 服务人员添加
     * @return
     */
    @RequestMapping("/addServicePeople")
    public String addServicePeople(@RequestBody ServicePeople servicePeople) {
        servicePeoPleService.addPeopel(servicePeople);
        return Result.OK.data(servicePeople);
    }
}
