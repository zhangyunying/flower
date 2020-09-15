package com.flower.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.flower.entity.ShoppingCart;
import com.flower.entity.UserOrder;
import com.flower.reponse.Result;
import com.flower.repository.FlowerRepository;
import com.flower.service.UserOrderService;
import com.flower.vo.ShoppingCartVo;
import com.flower.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private FlowerRepository flowerRepository;

    /**
     * 订单列表
     * @return 返回结果
     */
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
//        Integer userid = userOrder.getUserId();
        if (userId == null) {
            return Result.ALERT.alert("用户id不可以为空");
        }
        List<UserOrder> byUserId = userOrderService.findByUserId(Integer.valueOf(userId));
//        List<UserOrderVo> userOrderVoList = new ArrayList<>();
//        for (UserOrder order : byUserId) {
//            UserOrderVo userOrderVo = new UserOrderVo();
//            BeanUtil.copyProperties(order, userOrderVo);
//            userOrderVo.setOrderTimeStr(DateUtil.format(order.getOrderTime(), "yyyy-MM-dd HH:mm:ss"));

//            Optional<Flower> flowerOptional = flowerRepository.findById(order.getFlowerId());
//            userOrderVo.setFlower(flowerOptional.get());
//            userOrderVoList.add(userOrderVo);
//        }
        return Result.OK.data(byUserId);
    }


    /**
     * 删除订单
     *
     * @param userOrder 删除订单
     * @return 删除订单
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestBody UserOrder userOrder) {
        if (userOrder.getOrderId() == null) {
            return Result.ALERT.alert("订单id不可以为空");
        }
        userOrderService.delete(userOrder.getOrderId());
        return Result.OK.str();
    }

    /**
     * 生成订单
     *
     * @param userOrder 生成订单
     * @return 返回结果
     */
    @RequestMapping(value = "/save")
    public String save(@RequestBody UserOrder userOrder,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        System.out.println("userId_————————"+userId);
        if (userId != null && !userId.equals("")){
            userOrder.setUserId(Integer.valueOf(userId));
        }
        userOrder.setOrderTime(new Date());
        userOrderService.save(userOrder);
        return Result.OK.data(userOrder);
    }

    /**
     * 添加购物车
     *
     * @param shoppingCart 添加购物车
     * @return 返回结果
     */
    @RequestMapping(value = "/addCard")
    public String addCard(@RequestBody ShoppingCart shoppingCart,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        System.out.println("userId_————————"+userId);
        if (userId != null && !userId.equals("")){
            shoppingCart.setUserId(Integer.valueOf(userId));
        }
        userOrderService.addCard(shoppingCart);
        return Result.OK.data(shoppingCart);
    }


    /**
     * 购物车查询
     *
     * @return 返回结果
     */
    @RequestMapping(value = "/Card")
    public String listCard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        ShoppingCartVo shoppingCartVo = userOrderService.listCard(userId);
        return Result.OK.data(shoppingCartVo);
    }

    /**
     * 删除购物车
     *
     * @param cartId 删除购物车
     * @return 返回删除结果
     */
    @RequestMapping(value = "/deleteCard")
    public String deleteCard(@RequestParam("cartId") int cartId) {
        userOrderService.deleteCard(cartId);
        return Result.OK.str();
    }
}