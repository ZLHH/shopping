package com.example.controller;

import com.example.domain.Msg;
import com.example.domain.ProductInfo;
import com.example.service.HotService;
import com.example.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglh on 2018/5/17.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Msg showProduct(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum, @RequestParam(value="category")Integer category){
        List<ProductInfo> list = new ArrayList<ProductInfo>();
        PageHelper.startPage(pageNum, 12);
        list=productService.querryAll(category);
        if(!list.isEmpty()&&list.size()!=0){
            PageInfo<ProductInfo> pageInfo=new PageInfo<>(list);
            return Msg.success("").add("pageInfo", pageInfo);
        }
        return Msg.error("");
    }
}
