package me.spokenbot.service;

import lombok.extern.slf4j.Slf4j;
import me.spokenbot.dao.mapper.UserMapper;
import me.spokenbot.enums.UserRoleEnum;
import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserRegisterBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void register(String username, String password) throws Exception {
        //1. 生成加强密码
        String pwdHash = passwordEncoder.encode(password);
        //2. 插入数据库
        UserRegisterBO userRegisterBO = new UserRegisterBO();
        userRegisterBO.setUsername(username);
        userRegisterBO.setPwdHash(pwdHash);
        userRegisterBO.setRole(UserRoleEnum.Normal);
        userRegisterBO.setCreateAt(new Date());
        userRegisterBO.setUpdateAt(new Date());
        long x = userManager.save(userRegisterBO);
        log.info("id {}", x);
        //3. 生成一个JWT。JWT里的信息是username, userId等.
        
    }

}
