package com.example.service;

import com.example.dao.OrderDAO;
import com.example.domain.Adress;
import com.example.domain.OrderDetail;
import com.example.domain.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    public void saveAdress(Adress adress){
        orderDAO.saveAdress(adress);
    }

    public List<Adress> showAdress(Integer userid){
        List<Adress> adressList=orderDAO.showAdress(userid);
        return adressList;
    }

    public void reduce(Integer counts,Integer id){
        orderDAO.reduce(counts,id);
    }

    public void saveOrderMaster(OrderMaster orderMaster){
        orderDAO.saveOrderMaster(orderMaster);
    }

    public void saveOrderDetail(OrderDetail orderDetail){
        orderDAO.saveOrderDetail(orderDetail);
    }

    public void queryOrderById(String orderId, LocalDateTime updateTime){
        orderDAO.changeOrderStatusById(orderId,updateTime);
     }
}
