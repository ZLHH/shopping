package com.example.controller;

import com.example.domain.Msg;
import com.example.domain.UserMain;
import com.example.domain.UserMainDetail;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by zhanglh on 2018/3/12.
 */
@RestController
@RequestMapping("/shopping")
public class LoginController {

    @Autowired
    LoginService loginService;


    @RequestMapping("/login")
    @ResponseBody
    public Msg login(HttpServletRequest request, String account, String password) {
        HttpSession session = request.getSession();
        UserMain userMain=loginService.querryIdByName(account);
        if (userMain!=null){
            UserMainDetail userMainDetail = loginService.querryById(userMain.getId());
            if (userMainDetail.getPassword().equals(password)){
                return Msg.success("登陆成功");
            }else {
                return Msg.success("登陆失败，密码错误");
            }
        }else {
            return Msg.success("登陆失败，账号不存在");
        }
    }
}
