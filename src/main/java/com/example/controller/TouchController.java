package com.example.controller;

import com.example.domain.Cooperation;
import com.example.domain.Msg;
import com.example.domain.UserMain;
import com.example.domain.UserMainDetail;
import com.example.service.TouchServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * Created by zhanglh on 2018/5/6.
 */
@RestController
@RequestMapping("/touch")
public class TouchController {

    @Autowired
    TouchServce touchServce;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Msg save(String name, String phone, String time, String message) {
        Cooperation cooperation = new Cooperation();
        cooperation.setName(name);
        cooperation.setPhone(phone);
        cooperation.setTime(time);
        cooperation.setMessage(message);
        cooperation.setStatus(0);
        cooperation.setCreateTime(LocalDateTime.now());
        touchServce.save(cooperation);
        return Msg.success("提交成功!等待相关工作人员联系");
    }
}
