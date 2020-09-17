package com.flower.service.impl;

import cn.hutool.core.util.StrUtil;
import com.flower.entity.Flower;
import com.flower.repository.FlowerRepository;
import com.flower.service.FlowerService;
import com.flower.vo.FlowerQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;


    /**根据条件查询所有的鲜花列表*/
    @Override
    public List<Flower> findAll(FlowerQueryVo flowerQueryVo) {
//    public List<Flower> findAll(String flowerName, String flowerType, String flowerLanguage,String suitableFor) {
//        final String keyword = flowerQueryVo.getKeyword();
        final String flowerName = flowerQueryVo.getFlowerName();
        final String flowerType = flowerQueryVo.getFlowerType();
        final String flowerLanguage = flowerQueryVo.getFlowerLanguage();
        final String suitableFor = flowerQueryVo.getSuitableFor();
        return flowerRepository.findAll((Specification<Flower>) (root, cq, cb) -> {
            Predicate conjunction = cb.conjunction();
            if (StrUtil.isNotBlank(flowerName)) {
                conjunction.getExpressions().add(cb.like(root.get("flowerName"), "%" + flowerName + "%"));
            }
            if (StrUtil.isNotBlank(flowerType)) {
                conjunction.getExpressions().add(cb.like(root.get("flowerType"), "%" + flowerType + "%"));
            }
            if (StrUtil.isNotBlank(flowerLanguage)) {
                conjunction.getExpressions().add(cb.like(root.get("flowerLanguage"), "%" + flowerLanguage + "%"));
            }
            if (StrUtil.isNotBlank(suitableFor)) {
                conjunction.getExpressions().add(cb.like(root.get("suitableFor"), "%" + suitableFor + "%"));
            }
            return conjunction;
        });
//        return flowerRepository.find(flowerQueryVo.getFlowerName(),flowerQueryVo.getFlowerType(),
//                flowerQueryVo.getFlowerLanguage(),flowerQueryVo.getSuitableFor());
    }


    /**通过鲜花id查询鲜花信息*/
    @Override
    public Flower findById(Integer id) {
        Optional<Flower> flowerOptional = flowerRepository.findById(id);
        return flowerOptional.orElse(new Flower());
    }

    /**
     * 添加或者更新鲜花信息
     * @param flower
     */
    @Override
    public void addOrUpdate(Flower flower) {
        flowerRepository.save(flower);
    }

}
