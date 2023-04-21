package me.spokenbot.service;

import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserDetailsBO;
import me.spokenbot.model.bo.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoBO userInfoBO = userManager.loadUserInfoByName(username);
        return new UserDetailsBO(userInfoBO.getUsername(), userInfoBO.getPwdHash());
    }
}
