package com.flower.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ServiceVo implements Serializable {

    //模糊查询请求参数
    private String keyword;

    //服务id 查看详情请求参数
    private String serviceId;

}
