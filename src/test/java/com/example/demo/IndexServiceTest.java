package com.example.demo;

import com.example.dao.IndexDAO;
import com.example.domain.ProductInfo;
import com.example.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglh on 2018/3/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class IndexServiceTest {

    @Autowired
    IndexService indexService;

    @Test
    public void querryAll(){
        List<ProductInfo> list = new ArrayList<ProductInfo>();
        list = indexService.querryAll();
        for (ProductInfo l:list){
            System.out.println(l.toString());
        }
    }
}
