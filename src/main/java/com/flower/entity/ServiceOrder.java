package com.flower.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 淮南
 * @date 2020/7/27 23:04
 */
@Data
@Entity
@Table(name = "t_service_order")
@Accessors(chain = true)
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * 服务订单id
     */
    @Column(name = "service_order_id")
    private int serviceOrderId;

    /**
     * 服务id
     */
    @Column(name = "service_id")
    private int serviceId;

    /**
     * 服务人员id
     */
    @Column(name = "service_people_id")
    private int servicePeopleId;

    /**
     * 服务地址id
     */
    @Column(name = "address_id")
    private int addressId;

    /**
     * 服务订单备注
     */
    @Column(name = "service_order_info")
    private String serviceOrderInfo;

    /**
     * 服务订单状态
     */
    @Column(name = "service_order_status")
    private String serviceOrderStatus;

    /**
     * 服务订单时间
     */
    @Column(name = "service_order_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date serviceOrderTime;

}
