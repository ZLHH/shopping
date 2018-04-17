package com.example.demo;

import com.example.domain.UserMain;
import com.example.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Created by zhanglh on 2018/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RegisterServiceTest {
    @Autowired
    RegisterService registerService;

    @Test
    public void test(){
        UserMain userMain = new UserMain();
        userMain.setName("bob");
        userMain.setEmail("15279106323@163.com");
        userMain.setNickName("user");
        userMain.setStatus(0);
        userMain.setCreateTime(LocalDateTime.now());
        registerService.register(userMain);
    }
}
