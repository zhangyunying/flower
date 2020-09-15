package com.flower.repository;

import com.flower.entity.Flower;
import com.flower.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlowerRepository extends JpaRepository<Flower,Integer>,JpaSpecificationExecutor<Flower> {

}
