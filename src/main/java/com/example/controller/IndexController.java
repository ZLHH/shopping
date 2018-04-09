package com.example.controller;

import com.example.domain.Msg;
import com.example.domain.ProductInfo;
import com.example.domain.UserMain;
import com.example.service.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglh on 2018/3/29.
 */
@RestController
@RequestMapping("/querry")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    IndexService indexService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Msg showProduct(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        List<ProductInfo> list = new ArrayList<ProductInfo>();
        PageHelper.startPage(pageNum, 6);
        list=indexService.querryAll();
        if(!list.isEmpty()&&list.size()!=0){
            PageInfo<ProductInfo> pageInfo=new PageInfo<>(list);
            return Msg.success("").add("pageInfo", pageInfo);
        }
        return Msg.error("");
    }
}
