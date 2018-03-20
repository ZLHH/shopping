package com.example.service;

import com.example.dao.RegisterDAO;
import com.example.domain.UserMain;
import com.example.domain.UserMainDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanglh on 2018/3/14.
 */
@Service
public class RegisterService {

    @Autowired
    RegisterDAO registerDAO;

    public void register(UserMain userMain){
        registerDAO.save(userMain);
    }

    public void registerDetail(UserMainDetail userMainDetail){
        registerDAO.saveDetail(userMainDetail);
    }
}
