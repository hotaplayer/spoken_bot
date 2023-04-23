package me.spokenbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import java.util.UUID;

@Configuration
public class BeanConfig
{

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    AbstractRememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
        //token不存储，token由username、过期信息+签名构成，其中签名由key和username，pwd等哈希构成。
        TokenBasedRememberMeServices services =  new TokenBasedRememberMeServices(UUID.randomUUID().toString(), userDetailsService);
        services.setAlwaysRemember(true);
        return services;
    }
}
