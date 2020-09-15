package com.flower.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 淮南
 * @date 2020/7/27 23:04
 */
@Data
@Entity
@Table(name = "t_service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 服务id
     */
    @Column(name = "service_id")
    private int serviceId;

    /**
     * 服务名称
     */
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 服务价格
     */
    @Column(name = "service_price")
    private double servicePrice;

    /**
     * 服务次数
     */
    @Column(name = "service_num")
    private int serviceNum;

    /**
     * 服务内容
     */
    @Column(name = "service_info")
    private String serviceInfo;

    /**
     * 服务对象
     */
    @Column(name = "service_object")
    private String serviceObject;

    /**
     * 服务范围
     */
    @Column(name = "service_range")
    private String serviceRange;

}
