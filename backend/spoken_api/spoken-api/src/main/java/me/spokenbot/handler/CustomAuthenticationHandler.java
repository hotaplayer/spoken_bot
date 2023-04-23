package me.spokenbot.handler;

import cn.hutool.json.JSONUtil;
import me.spokenbot.enums.CodeEnums;
import me.spokenbot.model.response.CommonResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationHandler implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String json = JSONUtil.toJsonPrettyStr(CommonResponse.with(CodeEnums.AUTHENTICATE_FAILED));
        response.getWriter().println(json);

    }
}
