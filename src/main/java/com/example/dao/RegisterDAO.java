package com.example.dao;

import com.example.domain.UserMain;
import com.example.domain.UserMainDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by zhanglh on 2018/3/14.
 */
@Mapper
public interface RegisterDAO {

    void save(UserMain userMain);

    void saveDetail(UserMainDetail userMainDetail);
}
