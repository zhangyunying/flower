package com.flower.repository;

import com.flower.entity.ServicePeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface  ServicePeoPleRepository extends JpaSpecificationExecutor<ServicePeople> ,JpaRepository<ServicePeople,Integer>{
}
