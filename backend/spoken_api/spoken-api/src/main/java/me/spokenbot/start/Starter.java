package me.spokenbot.start;

import me.spokenbot.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Starter implements ApplicationRunner {

    @Autowired
    private UserMapper mapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mapper.select();
    }
}
