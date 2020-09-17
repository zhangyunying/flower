package com.flower.repository;

import com.flower.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower,Integer>,JpaSpecificationExecutor<Flower> {


    @Query(value = "select * from t_flower where if(?1 !='',flower_name=?1,1=1) and if(?2 !='',flower_type=?2,1=1)" +
            "and if(?3 !='',flower_language=?3,1=1) and if(?4 !='',suitable_for=?4,1=1) ",nativeQuery = true)
    List<Flower> find(String flower_name, String flower_type, String flower_language,String suitable_for);


}
