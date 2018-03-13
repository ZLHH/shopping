package com.example.demo;

import com.example.domain.UserMain;
import com.example.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhanglh on 2018/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class loginServiceTest {
    @Autowired
    LoginService loginService;

    @Test
    public void test(){
        UserMain userMain = loginService.querryIdByName("admin");
        System.out.println(userMain.getEmail());
    }
}
