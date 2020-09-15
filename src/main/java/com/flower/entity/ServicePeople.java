package com.flower.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 淮南
 * @date 2020/7/27 23:04
 */
@Data
@Entity
@Table(name = "t_service_people")
public class ServicePeople {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 服务人员id
     */
    @Column(name = "service_people_id")
    private int servicePeopleId;

    /**
     * 姓名
     */
    @Column(name = "service_people_name")
    private String servicePeopleName;

    /**
     * 技能
     */
    @Column(name = "service_people_skill")
    private String servicePeopleSkill;

    /**
     * 位置
     */
    @Column(name = "service_people_location")
    private String servicePeopleLocation;

    /**
     * 简介
     */
    @Column(name = "service_people_info")
    private String servicePeopleInfo;

    /**
     * 电话
     */
    @Column(name = "service_people_phone")
    private String servicePeoplePhone;

    /**
     * 头像图片
     */
    @Column(name = "service_people_url")
    private String servicePeopleUrl;

}
