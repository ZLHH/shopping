package com.example.service;

import com.example.dao.IndexDAO;
import com.example.domain.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanglh on 2018/3/29.
 */
@Service
public class IndexService {
    @Autowired
    IndexDAO indexDAO;

    public List<ProductInfo> querryAll(){
        return indexDAO.querryAll();
    }

    public ProductInfo getProductById(String id){
        return indexDAO.getProductById(id);
    }
}
