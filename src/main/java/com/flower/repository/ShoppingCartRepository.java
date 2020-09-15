package com.flower.repository;

import com.flower.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer>,JpaSpecificationExecutor<ShoppingCart>{
    void deleteByCartId(Integer cartId);

    ShoppingCart findByCartId(Integer cartId);
}
