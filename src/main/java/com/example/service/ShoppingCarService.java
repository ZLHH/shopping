package com.example.service;

import com.example.dao.ShoppingCarDAO;
import com.example.domain.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanglh on 2018/4/22.
 */
@Service
public class ShoppingCarService {

    @Autowired
    ShoppingCarDAO shoppingCarDAO;

    public void save(ShoppingCar shoppingCar){
        shoppingCarDAO.save(shoppingCar);
    }

    public List<ShoppingCar> querryAll(Integer id){
        return shoppingCarDAO.querryAll(id);
    }

    public void delete(Integer id){
         shoppingCarDAO.delete(id);
    }

    public Integer queryTotal(Integer id){
        return shoppingCarDAO.queryTotal(id);
    }

    public ShoppingCar querryAllByIds(Integer ids,Integer id){
        return shoppingCarDAO.querryAllByIds(ids,id);
    }

    public ShoppingCar querryAllById(Integer ids){
        return shoppingCarDAO.querryAllById(ids);
    }

    public void changeStatus(Integer id){
        shoppingCarDAO.changeStatus(id);
    }
}
