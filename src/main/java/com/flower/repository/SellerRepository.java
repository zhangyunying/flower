package com.flower.repository;

import com.flower.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer>{

    String findSellerNameByUserId(int userId);
}
