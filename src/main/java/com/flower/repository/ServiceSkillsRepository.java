package com.flower.repository;

import com.flower.entity.ServiceSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 淮南
 * @date 2020/9/16 19:17
 */
public interface ServiceSkillsRepository extends JpaRepository<ServiceSkills,Integer>,JpaSpecificationExecutor<ServiceSkills> {

    @Query("select s.serviceId from ServiceSkills  s where s.skillId = ?1")
    int findByServiceId(int skillId);

    @Query("select s.servicePeopleId from ServiceSkills  s where s.skillId = ?1")
    int findByServicePeopleId(int skillId);

}
