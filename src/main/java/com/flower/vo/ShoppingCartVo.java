package com.flower.vo;

import com.flower.entity.Flower;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShoppingCartVo implements Serializable {

    /*购物车id*/
    private int cartId;
    /*产品列表*/
    private List<Flower> flowerList;
}
