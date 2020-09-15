package com.flower.api;

import com.flower.entity.Service;
import com.flower.reponse.Result;
import com.flower.service.ServiceService;
import com.flower.vo.ServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;
    /**
     * 服务列表
     * @param serviceVo
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestBody ServiceVo serviceVo) {
       List<Service> serviceList = serviceService.list(serviceVo.getKeyword());
        return Result.OK.data(serviceList);
    }

    /**
     * 服务查询
     * @param serviceVo
     * @return
     */
    @RequestMapping("/findOne")
    public String findOne(@RequestBody ServiceVo serviceVo) {
        Service service = serviceService.findOne(serviceVo.getServiceId());
        return Result.OK.data(service);
    }


    /**
     * 服务添加
     * @param service
     * @return
     */
    @RequestMapping("/addService")
    public String addService(@RequestBody Service service) {
        serviceService.addService(service);
        return Result.OK.data(service);
    }
}
