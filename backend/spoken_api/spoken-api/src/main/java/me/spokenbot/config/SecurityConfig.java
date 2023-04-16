package me.spokenbot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // disable X-Frame-Options header
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .cors().configurationSource(corsConfiguration());
//        http
//                .csrf().disable()
//                .cors()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers(authConfig.getPermitAllApiList().toArray(new String[0])).permitAll()
//                .antMatchers(authConfig.getAnonymousApi()).anonymous()
//                .antMatchers(authConfig.getRoleAuth().getAdminAuth().toArray(new String[0])).hasAnyAuthority(AccountType.ADMIN.getRoleName())
//                .antMatchers(authConfig.getRoleAuth().getCompanyAuth().toArray(new String[0])).hasAnyAuthority(AccountType.COMPANY.getRoleName())
//                // .antMatchers(authConfig.getRoleAuth().getWitnessAuth().stream().toArray(String[]::new)).hasAnyAuthority(AccountType.WITNESS.getRoleName())
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPointHandler)  // 认证失败异常处理配置
//                .accessDeniedHandler(accessDeniedHandlerHandler);  // 授权失败异常处理配置
    }


    CorsConfigurationSource corsConfiguration (){
        // Cors配置类
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(false); // 是否返回时生成凭证
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