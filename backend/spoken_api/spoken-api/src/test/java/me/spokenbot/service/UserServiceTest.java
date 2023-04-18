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
        userService.register("test","pwd");
        
    }

}
