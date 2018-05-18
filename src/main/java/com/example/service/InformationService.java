package com.example.service;

import com.example.dao.InformationDAO;
import com.example.domain.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Service
public class InformationService {

    @Autowired
    InformationDAO informationDAO;

    public List<Information> querryAll(){
        return informationDAO.querryAll();
    }

    public Information getInformationById(Integer id){
        return informationDAO.getInformationById(id);
    }


}
