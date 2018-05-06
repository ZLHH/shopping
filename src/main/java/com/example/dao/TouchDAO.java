package com.example.dao;

import com.example.domain.Cooperation;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Mapper
public interface TouchDAO {

    void save(Cooperation cooperation);
}
