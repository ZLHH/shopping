package com.example.dao;

import com.example.domain.Adress;
import com.example.domain.OrderDetail;
import com.example.domain.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhanglh on 2018/5/6.
 */
@Mapper
public interface OrderDAO {

    void saveAdress(Adress adress);

    List<Adress> showAdress(Integer userid);

    void reduce(@Param("counts")Integer counts,@Param("id") Integer id);

    void saveOrderMaster(OrderMaster orderMaster);

    void saveOrderDetail(OrderDetail orderDetail);

    void   changeOrderStatusById(@Param("orderId")String orderId,@Param("updateTime")LocalDateTime updateTime);
}
