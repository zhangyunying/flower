package com.flower.service;

import com.flower.entity.ShoppingCart;
import com.flower.entity.UserOrder;
import com.flower.vo.ShoppingCartVo;

import java.util.List;

public interface UserOrderService {

    /**根据用户编号查询订单列表*/
    List<UserOrder> findByUserId(Integer userid);

    /**根据id删除订单*/
    void delete(Integer orderId);

    /**生成订单*/
    void save(UserOrder userOrder);
/**添加购物车*/
    void addCard(ShoppingCart shoppingCart);

    void deleteCard(int cartId);

    ShoppingCartVo listCard(String userId);


}
