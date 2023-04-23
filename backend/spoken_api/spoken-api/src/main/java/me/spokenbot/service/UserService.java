package me.spokenbot.service;

import lombok.extern.slf4j.Slf4j;
import me.spokenbot.enums.CodeEnums;
import me.spokenbot.enums.UserRoleEnum;
import me.spokenbot.errors.SpokenBotException;
import me.spokenbot.manager.HttpContextManager;
import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserDetailsBO;
import me.spokenbot.model.bo.UserInfoBO;
import me.spokenbot.model.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    public CommonResponse register(String username, String password) throws Exception {
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
        //3. 记住我
        UserDetailsBO userDetails = new UserDetailsBO(userInfoBO);
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, Collections.EMPTY_LIST);
        rememberMeServices.loginSuccess(httpContextManager.currentRequest(), httpContextManager.currentResponse(), auth);
        return CommonResponse.success(null);
    }

    public CommonResponse login(String username, String password) throws Exception{
        //1. 验证
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
        auth = authenticationManager.authenticate(auth);
        //2. 记住我
        rememberMeServices.loginSuccess(httpContextManager.currentRequest(), httpContextManager.currentResponse(), auth);
        return CommonResponse.success(null);
    }
}
