package com.example.service;

import com.example.dao.TouchDAO;
import com.example.domain.Cooperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Service
public class TouchServce {

    @Autowired
    TouchDAO touchDAO;

    public void save(Cooperation cooperation){
        touchDAO.save(cooperation);
    }
}
