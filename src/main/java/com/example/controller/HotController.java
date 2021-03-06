package com.example.controller;

import com.example.domain.Msg;
import com.example.domain.ProductInfo;
import com.example.domain.ShoppingCar;
import com.example.domain.UserMain;
import com.example.service.HotService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by zhanglh on 2018/5/6.
 */
@RestController
@RequestMapping("/hot")
public class HotController {

    @Autowired
    HotService hotService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Msg showProduct(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,@RequestParam(value="category")Integer category){
        List<ProductInfo> list = new ArrayList<ProductInfo>();
        PageHelper.startPage(pageNum, 6);
        list=hotService.querryAll(category);
        if(!list.isEmpty()&&list.size()!=0){
            PageInfo<ProductInfo> pageInfo=new PageInfo<>(list);
            return Msg.success("").add("pageInfo", pageInfo);
        }
        return Msg.error("");
    }
}
