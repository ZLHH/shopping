package com.example.controller;

import com.example.domain.Msg;
import com.example.domain.UserMain;
import com.example.domain.UserMainDetail;
import com.example.service.LoginService;
import com.example.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * Created by zhanglh on 2018/3/14.
 */
@RestController
@RequestMapping("/shop")
public class RegisterController {

    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    RegisterService registerService;
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Msg register(HttpServletRequest request, String account, String password, String email, String verifycode) {
        HttpSession session = request.getSession();
        // 获取验证码
        String code = (String) request.getSession().getAttribute("RANDOM_CODE_KEY");
        System.out.println("account"+account);
        UserMain userMain = new UserMain();
        userMain=loginService.querryIdByName(account);
        if (userMain != null){
            return Msg.error("账号已存在！");
        }else{
            userMain.setName(account);
            userMain.setEmail(email);
            userMain.setNickName("user");
            userMain.setRole(0);
            userMain.setCreateTime(LocalDateTime.now());
            registerService.register(userMain);
            session.setAttribute("userMain", userMain);
        }
        UserMainDetail userMainDetail = new UserMainDetail();
        userMainDetail.setPassword(password);
        userMainDetail.setPhoneNumber("15279106323");
        userMainDetail.setRegisterTime(LocalDateTime.now());
        registerService.registerDetail(userMainDetail);

        return Msg.success("注册成功!");

    }
}
