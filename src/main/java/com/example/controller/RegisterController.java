package com.example.controller;

import com.example.domain.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhanglh on 2018/3/14.
 */
@RestController
@RequestMapping("/shopping")
public class RegisterController {

    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Msg register(HttpServletRequest request, String account, String password, String email, String verifycode) {
        HttpSession session = request.getSession();
        // 获取验证码
        String code = (String) request.getSession().getAttribute("RANDOM_CODE_KEY");
        System.out.println("account"+account);

//        if(!code.equals(pcode)){
//            return Msg.error("验证码错误");
//        }
//        Integer id=studentService.register(student);
//        if (id!=null) {
//            request.getSession().removeAttribute("RANDOM_CODE_KEY");
//            return Msg.success("注册成功").add("id", id);
//        }
        return Msg.error("");
    }
}
