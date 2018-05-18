package com.example.service;

import com.example.dao.HotDAO;
import com.example.domain.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Service
public class HotService {

    @Autowired
    HotDAO hotDAO;

    public List<ProductInfo> querryAll(Integer category){
        return hotDAO.querryAll(category);
    }


}
