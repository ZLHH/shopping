package com.example.dao;

import com.example.domain.Adress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Mapper
public interface OrderDAO {

    void saveAdress(Adress adress);

    List<Adress> showAdress(Integer userid);
}
