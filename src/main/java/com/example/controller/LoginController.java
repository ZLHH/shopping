package com.example.controller;

import com.example.domain.Msg;
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
    @RequestMapping("/login")
    @ResponseBody
    public Msg login(HttpServletRequest request, String account, String password) {
        HttpSession session = request.getSession();
        System.out.println("账号："+account);
        System.out.println("密码："+password);
        return Msg.success("登陆成功");
    }
}
