package com.flower.repository;

import com.flower.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface SupplyRepository extends JpaRepository<Supply,Integer>,JpaSpecificationExecutor<Supply> {

    /**
     * 通过供应id查id
     * @param supplyId
     * @return
     */
    @Query("select s from Supply s where s.id = ?1")
    Supply findBySupplyId(int supplyId);

//    /**
//     * 通过供应id查商家id
//     * @param supplyId
//     * @return
//     */
//    @Query("select s from Supply s where s.id = ?1")
//    int findSellerIdById(int supplyId);
}
