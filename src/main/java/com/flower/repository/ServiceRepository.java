package com.flower.repository;

import com.flower.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceRepository extends JpaRepository<Service,Integer> ,JpaSpecificationExecutor<Service> {

    Service findAllByServiceId(int serviceId);
}
