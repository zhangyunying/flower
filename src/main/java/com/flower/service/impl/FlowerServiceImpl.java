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
import java.util.List;
import java.util.Optional;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;


    /**根据条件查询所有的鲜花列表*/
    @Override
    public List<Flower> findAll(FlowerQueryVo flowerQueryVo) {
        final String keyword = flowerQueryVo.getKeyword();
        return flowerRepository.findAll((Specification<Flower>) (root, cq, cb) -> {
            Predicate conjunction = cb.conjunction();
            if (StrUtil.isNotBlank(keyword)) {
                conjunction.getExpressions().add(cb.like(root.get("flowerName"), "%" + keyword + "%"));
            }
            return conjunction;
        });
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
