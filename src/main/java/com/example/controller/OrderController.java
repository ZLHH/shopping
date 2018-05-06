package com.example.controller;

import com.example.domain.*;
import com.example.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
}
