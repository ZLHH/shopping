package com.example.controller;

import com.example.domain.Msg;
import com.example.domain.UserMain;
import com.example.domain.UserMainDetail;
import com.example.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhanglh on 2018/3/12.
 */
@RestController
@RequestMapping("/shopping")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    @ResponseBody
    public Msg checklogin(HttpSession session){
        UserMain userMain=(UserMain) session.getAttribute("userMain");
        if(userMain!=null){
            return Msg.success("").add("student", userMain);
        }
        return Msg.error("");
    }


    @RequestMapping("/login")
    @ResponseBody
    public Msg login(HttpServletRequest request, String account, String password) {
        HttpSession session = request.getSession();
        UserMain userMain=loginService.querryIdByName(account);
        if (userMain!=null){
            UserMainDetail userMainDetail = loginService.querryById(userMain.getId());
            if (userMainDetail.getPassword().equals(password)){
                session.setAttribute("userMain", userMain);
                return Msg.success("登陆成功");
            }else {
                return Msg.success("登陆失败，密码错误");
            }
        }else {
            return Msg.success("登陆失败，账号不存在");
        }
    }
}
