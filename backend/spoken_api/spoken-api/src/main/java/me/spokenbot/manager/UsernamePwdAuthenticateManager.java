package me.spokenbot.manager;

import me.spokenbot.enums.CodeEnums;
import me.spokenbot.errors.SpokenBotException;
import me.spokenbot.model.bo.UserDetailsBO;
import me.spokenbot.model.bo.UserInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UsernamePwdAuthenticateManager implements AuthenticationManager {
    
    @Autowired
    private IUserManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!(authentication instanceof UsernamePasswordAuthenticationToken)){
            throw new AuthenticationServiceException("Invalid authentication type");
        }
        UsernamePasswordAuthenticationToken authRequest = (UsernamePasswordAuthenticationToken) authentication;
        String username = (String)authRequest.getPrincipal();
        String password = (String)authRequest.getCredentials();
        UserInfoBO userInfoBO = userManager.loadUserInfoByName(username);
        if (userInfoBO == null){
            throw new UsernameNotFoundException("");
        }
        if (!passwordEncoder.matches(password, userInfoBO.getPwdHash())){
            throw new BadCredentialsException("");
        };
        return new UsernamePasswordAuthenticationToken(username, null, Collections.EMPTY_LIST);
    }
}
