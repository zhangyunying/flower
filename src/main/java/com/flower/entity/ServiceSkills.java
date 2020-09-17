package com.flower.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 鲜花信息
 * @author 淮南
 */
@Data
@Entity
@Table(name = "t_service_skills")
@Accessors(chain = true)
public class ServiceSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    /**
     * 服务人员的服务技能对应id
     */
    @Column(name = "skill_id")
    private int skillId;

    /**
     * 服务人员id
     */
    @Column(name = "service_people_id")
    private int servicePeopleId;

    /**
     * 服务id
     */
    @Column(name = "service_id")
    private int serviceId;

}
