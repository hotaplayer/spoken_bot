package me.spokenbot.service;

import lombok.extern.slf4j.Slf4j;
import me.spokenbot.ServerApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserServiceTest extends ServerApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception{
        userService.register("aaa","aaa");
        //验证rememberMe功能是否成功
        //获取一个RememberMeService，它是什么时候注入的？
        //RememberMeService里用的非持久化类型的token，由用户名+签名构成。签名的密码是加强密码吗？
        //返回正常数据后，还要返回setCookie

    }

}
