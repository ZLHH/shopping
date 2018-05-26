package com.example.controller;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
import com.example.domain.*;
import com.example.service.OrderService;
import com.example.service.ShoppingCarService;
import com.example.utils.KeyUtil;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglh on 2018/5/6.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ShoppingCarService shoppingCarService;

    @RequestMapping(value = "/saveAdress",method = RequestMethod.POST)
    @ResponseBody
    public Msg register(HttpSession session, String name, String phone, String adress) {
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        Adress myAdress=new Adress();
        if (userMain == null){
            return Msg.error("请先登录!");
        }else {
            myAdress.setName(name);
            myAdress.setPhone(phone);
            myAdress.setAdress(adress);
            myAdress.setUserId(userMain.getId());
            myAdress.setCreateTime(LocalDateTime.now());
            orderService.saveAdress(myAdress);
        }
        return Msg.success("提交成功!");
    }

    @RequestMapping(value = "/adresslist", method = RequestMethod.GET)
    @ResponseBody
    public Msg showAdress(HttpSession session){
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        if (userMain!=null){
            List<Adress> list = orderService.showAdress(userMain.getId());
            if(!list.isEmpty()&&list.size()!=0){
                PageInfo<Adress> pageInfo=new PageInfo<>(list);
                return Msg.success("").add("pageInfo", pageInfo);
            }else
                return null;
        }else {
            return Msg.error("请先登录");
        }
    }

    @RequestMapping(value = "/saveOrder",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveOrder(HttpSession session, String name, String phone, String adress, String ids) {
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        String[] is= ids.split(",");
        if (userMain == null){
            return Msg.error("请先登录!");
        }else {
            String orderId = KeyUtil.genUniqueKey();
            session.setAttribute("orderId", orderId);
            OrderDetail orderDetail = new OrderDetail();
            BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
            OrderMaster orderMaster = new OrderMaster();
            orderMaster.setOrderId(orderId);
            orderMaster.setBuyerName(name);
            orderMaster.setBuyerAddress(adress);
            orderMaster.setBuyerPhone(phone);
            orderMaster.setOrderStatus(0);
            orderMaster.setPayStatus(0);
            orderMaster.setCreateTime(LocalDateTime.now());
            JSONArray conditionList = JSONArray.fromObject(ids);
            for (int i=0;i<conditionList.size();i++){
                ShoppingCar shoppingCar = shoppingCarService.querryAllByIds(Integer.valueOf(conditionList.get(i).toString()),userMain.getId());
                //2. 计算订单总价
                orderAmount = shoppingCar.getProductPrice()
                        .multiply(new BigDecimal(shoppingCar.getCounts()))
                        .add(orderAmount);
                //减库存
                orderService.reduce(shoppingCar.getCounts(),shoppingCar.getProductId());
                //改变购物车商品状态
                shoppingCarService.changeStatus(shoppingCar.getId());
                orderDetail.setOrderId(orderId);
                orderDetail.setProductId(shoppingCar.getProductId().toString());
                orderDetail.setProductName(shoppingCar.getProductName());
                orderDetail.setProductPrice(shoppingCar.getProductPrice());
                orderDetail.setProductQuantity(shoppingCar.getCounts());
                orderDetail.setCreateTime(LocalDateTime.now());
                orderDetail.setDetailId(KeyUtil.genUniqueKey());
                orderService.saveOrderDetail(orderDetail);
            }
            orderMaster.setOrderAmount(orderAmount);
            orderMaster.setBuyerOpenid("abc123");
            orderService.saveOrderMaster(orderMaster);
        }
        return Msg.success("提交成功!");
    }
}
