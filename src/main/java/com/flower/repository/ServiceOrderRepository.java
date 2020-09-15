package com.flower.repository;

import com.flower.entity.ServiceOrder;
import com.flower.entity.ServicePeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceOrderRepository extends JpaSpecificationExecutor<ServiceOrder> ,JpaRepository<ServiceOrder,Integer>{
}
