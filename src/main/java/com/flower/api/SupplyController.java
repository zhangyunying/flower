package com.flower.api;

import com.flower.entity.Supply;
import com.flower.reponse.Result;
import com.flower.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 淮南
 * @date 2020/8/28 15:33
 */
@RequestMapping("/supply")
@RestController
public class SupplyController {


    @Autowired
    SupplyService supplyService;

    /**
     * 添加或者更新供应信息
     * @return 响应结果
     */
    @RequestMapping("/addOrUpdate")
    public String addOrUpdate(@RequestBody Supply supply) {
        System.out.println("打印flower"+supply);
        supplyService.save(supply);
        return Result.OK.str();
    }

}
