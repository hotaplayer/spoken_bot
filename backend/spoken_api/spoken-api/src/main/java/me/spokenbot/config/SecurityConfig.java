package me.spokenbot.config;


import me.spokenbot.handler.CustomAccessDeniedHandler;
import me.spokenbot.handler.CustomAuthenticationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/api/user/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors().configurationSource(corsConfiguration())
                .and()
                .rememberMe()
                .rememberMeServices(applicationContext.getBean(RememberMeServices.class))
                .tokenValiditySeconds(-1)//默认两周
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationHandler())
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }


    private CorsConfigurationSource corsConfiguration (){
        // Cors配置类
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);//允许跨域携带cookie
        corsConfiguration.setAllowedHeaders(Arrays.asList("*")); // 允许请求携带哪些请求头信息
        corsConfiguration.setAllowedMethods(Arrays.asList("*")); // 允许哪些类型的请求方法
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // 允许哪些域可以进行方法
        corsConfiguration.setMaxAge(3600L); // 设置预检的最大的时长
        corsConfiguration.setExposedHeaders(Collections.emptyList()); // 设置返回暴露的响应头信息

        // 设置注册URL 配置类
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource() ;
        source.registerCorsConfiguration("/**",corsConfiguration);

        return source;
    }



}