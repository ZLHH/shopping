package com.example.dao;

import com.example.domain.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zhanglh on 2018/3/29.
 */
@Mapper
public interface IndexDAO {

    List<ProductInfo> querryAll();

    ProductInfo getProductById(String id);

}
