package com.flower.service.impl;

import com.flower.entity.Flower;
import com.flower.entity.ShoppingCart;
import com.flower.entity.UserOrder;
import com.flower.repository.FlowerRepository;
import com.flower.repository.ShoppingCartRepository;
import com.flower.repository.UserOrderRepository;
import com.flower.service.SupplyService;
import com.flower.service.UserOrderService;
import com.flower.vo.ShoppingCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderRepository userOrderRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    SupplyService supplyService;

    @Override
    public List<UserOrder> findByUserId(Integer userid) {
//        UserOrder userOrder = new UserOrder();
//        userOrder.setUserId(userid);
//        Example<UserOrder> example = Example.of(userOrder);
//        return userOrderRepository.findAll(example);
        return userOrderRepository.findAll();
    }



    @Override
    public void delete(Integer orderId) {
        userOrderRepository.deleteById(orderId);
    }

    @Override
    public void save(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public void addCard(ShoppingCart shoppingCart) {
        int supplyId = shoppingCart.getSupplyId();
        int flowerId = supplyService.findFlowerBySupplyId(supplyId).getFlowerId();
        int userId = shoppingCart.getUserId();
        //将匹配对象封装成Example对象
        Example<ShoppingCart> example = Example.of(new ShoppingCart().setUserId(userId));
//        //查询
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll(example);
        if (shoppingCarts.isEmpty()) {
            shoppingCartRepository.save(shoppingCart);
            return;
        }
        for (ShoppingCart cart : shoppingCarts) {
            if (supplyService.findFlowerBySupplyId(cart.getSupplyId()).getFlowerId() == flowerId) {
                cart.setCount(cart.getCount() + 1);
                shoppingCartRepository.save(cart);
                return;
            }
        }
        int cartId = shoppingCarts.get(0).getCartId();
        shoppingCart.setCount(1).setCartId(cartId);
            System.out.println("——————shoppingCart"+shoppingCart);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteCard(int cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByCartId(cartId);
        shoppingCartRepository.delete(shoppingCart);
    }

    @Override
    public ShoppingCartVo listCard(String userId) {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll((Specification<ShoppingCart>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("userId"), userId));
        ShoppingCartVo shoppingCartVo = new ShoppingCartVo();
        if (shoppingCartList.isEmpty()) {
            shoppingCartVo.setFlowerList(new ArrayList<>());
        }
        shoppingCartVo.setCartId(shoppingCartList.get(0).getCartId());
        List<Flower> list = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCartList) {
            int flowerId = supplyService.findFlowerBySupplyId(shoppingCart.getSupplyId()).getFlowerId();
            Flower flower = flowerRepository.findById(flowerId).get();
            list.add(flower);
        }
        shoppingCartVo.setFlowerList(list);
        return shoppingCartVo;
    }

}
