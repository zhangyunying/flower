package com.flower.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.flower.entity.Flower;
import com.flower.entity.ShoppingCart;
import com.flower.entity.UserOrder;
import com.flower.reponse.Result;
import com.flower.repository.FlowerRepository;
import com.flower.service.SupplyService;
import com.flower.service.UserOrderService;
import com.flower.vo.ShoppingCartVo;
import com.flower.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private SupplyService supplyService;

    /**
     * 订单列表
     * @return 返回结果
     */
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        if (userId.equals("null")) {
            return Result.ALERT.alert("没有登录，无法查看。请登录");
        }
        List<UserOrder> byUserId = userOrderService.findByUserId(Integer.valueOf(userId));
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        for (UserOrder order : byUserId) {
            UserOrderVo userOrderVo = new UserOrderVo();
            BeanUtil.copyProperties(order, userOrderVo);
            userOrderVo.setOrderTimeStr(DateUtil.format(order.getOrderTime(), "yyyy-MM-dd HH:mm:ss"));

            Optional<Flower> flowerOptional = flowerRepository.findById(
                    supplyService.findFlowerBySupplyId(order.getSupplyId()).getFlowerId()
            );
            userOrderVo.setFlower(flowerOptional.get());
            userOrderVoList.add(userOrderVo);
        }
        return Result.OK.data(byUserId);
    }


    /**
     * 删除订单
     *
     * @param orderId 删除订单
     * @return 删除订单
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("orderId") int orderId,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        System.out.println("___——————————"+userId);
        if (userId.equals("null")) {
            return Result.ALERT.alert("没有登录，无法查看。请登录");
        }
        userOrderService.delete(orderId);
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
        if (!userId.equals("null")){
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
     * 购物车列表
     *
     * @return 返回结果
     */
    @RequestMapping(value = "/Card")
    public String listCard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        if (userId.equals("null")) {
            return Result.ALERT.alert("没有登录，无法查看。请登录");
        }
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
    public String deleteCard(@RequestParam("cartId") int cartId,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        if (userId.equals("null")) {
            return Result.ALERT.alert("没有登录，无法查看。请登录");
        }
        userOrderService.deleteCard(cartId);
        return Result.OK.str();
    }
}