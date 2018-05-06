package com.example.dao;

import com.example.domain.ShoppingCar;
import com.example.domain.UserMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zhanglh on 2018/4/22.
 */
@Mapper
public interface ShoppingCarDAO {

    void save(ShoppingCar shoppingCar);

    List<ShoppingCar> querryAll(Integer id);

    void delete(Integer id);

    int queryTotal(Integer id);
}
