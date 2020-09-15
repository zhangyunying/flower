package com.flower.repository;

import com.flower.entity.Dynamic;
import com.flower.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DynamicRepository extends JpaRepository<Dynamic,Integer>,JpaSpecificationExecutor<Dynamic> {

}
