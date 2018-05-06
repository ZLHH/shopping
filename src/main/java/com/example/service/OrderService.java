package com.example.service;

import com.example.dao.OrderDAO;
import com.example.domain.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
