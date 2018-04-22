package com.example.controller;

import com.example.domain.*;
import com.example.service.ShoppingCarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglh on 2018/4/22.
 */
@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCarController {

    @Autowired
    ShoppingCarService shoppingCarService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Msg save(HttpSession session, Integer productId, BigDecimal productPrice, Integer counts,String productName) {
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setUserId(userMain.getId());
        shoppingCar.setProductId(productId);
        shoppingCar.setProductPrice(productPrice);
        shoppingCar.setCounts(counts);
        shoppingCar.setCreateTime(LocalDateTime.now());
        shoppingCar.setProductName(productName);
        shoppingCarService.save(shoppingCar);
        return Msg.success("加入购物车成功!");

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Msg showProduct(HttpSession session){
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        List<ShoppingCar> list = new ArrayList<ShoppingCar>();
        list=shoppingCarService.querryAll(userMain.getId());
        if(!list.isEmpty()&&list.size()!=0){
            for (ShoppingCar car:list){
                car.setSrc("images/rc-"+car.getProductId()+".jpg");
            }
            return Msg.success("").add("shopcartdatas", list);
        }
        return Msg.error("");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Msg delete(Integer id) {
        shoppingCarService.delete(id);
        return Msg.success("");
    }

    /**
     * 购物车数量
     */
    @RequestMapping(value = "/totle",method = RequestMethod.GET)
    @ResponseBody
    public Msg queryTotal(HttpSession session) {
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        if (userMain!=null){
            int totle = shoppingCarService.queryTotal(userMain.getId());
            return Msg.success("").add("totle",totle);
        }else
            return null;

    }
}
