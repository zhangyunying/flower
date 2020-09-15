package com.flower.api;

import com.flower.entity.Flower;
import com.flower.reponse.Result;
import com.flower.service.FlowerService;
import com.flower.vo.FlowerQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/flower")
@RestController
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    /**
     * 查询所有的鲜花
     * @return 响应结果
     */
    @RequestMapping("/findAll")
    public String findAll(@RequestBody FlowerQueryVo flowerQueryVo) {
        List<Flower> flowerList = flowerService.findAll(flowerQueryVo);
        return Result.OK.data(flowerList);
    }

    /**
     * 通过id查询鲜花信息
     * @return 响应结果
     */
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable Integer id) {
        Flower flower =  flowerService.findById(id);
        return Result.OK.data(flower);
    }

    /**
     * 添加或者更新鲜花信息
     * @return 响应结果
     */
    @RequestMapping("/addOrUpdate")
    public String addOrUpdate(@RequestBody Flower flower) {
        System.out.println("打印flower"+flower);
        flowerService.addOrUpdate(flower);
        return Result.OK.str();
    }


}
