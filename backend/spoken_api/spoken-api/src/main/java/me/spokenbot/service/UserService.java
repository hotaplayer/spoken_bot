package me.spokenbot.service;

import lombok.extern.slf4j.Slf4j;
import me.spokenbot.enums.CodeEnums;
import me.spokenbot.enums.UserRoleEnum;
import me.spokenbot.errors.SpokenBotException;
import me.spokenbot.manager.HttpContextManager;
import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserDetailsBO;
import me.spokenbot.model.bo.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AbstractRememberMeServices rememberMeServices;

    @Autowired
    private HttpContextManager httpContextManager;

    public void register(String username, String password) throws Exception {
        //1. 生成加强密码
        String pwdHash = passwordEncoder.encode(password);
        //2. 插入数据库
        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setUsername(username);
        userInfoBO.setPwdHash(pwdHash);
        userInfoBO.setRole(UserRoleEnum.Normal);
        userInfoBO.setCreateAt(new Date());
        userInfoBO.setUpdateAt(new Date());
        userManager.save(userInfoBO);
        //3. 进行认证，包括使用rememberMe生成json等
        UserDetailsBO userDetails = new UserDetailsBO(username, pwdHash);
        Authentication auth = new RememberMeAuthenticationToken(rememberMeServices.getKey(), userDetails, Collections.EMPTY_LIST);
        rememberMeServices.loginSuccess(httpContextManager.currentRequest(), httpContextManager.currentResponse(), auth);
    }


    //登陆成功后，调用rememberMeService，创建token、返回cookie
    public UserInfoBO getUserInfoByName(String username) throws UsernameNotFoundException {
        UserInfoBO userInfoBO = userManager.loadUserInfoByName(username);
        if (userInfoBO == null){
            throw new UsernameNotFoundException("Username for found:"+username);
        }
        return userInfoBO;
    }
}
