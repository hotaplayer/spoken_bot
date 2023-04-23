package me.spokenbot.handler;


import cn.hutool.json.JSONUtil;
import me.spokenbot.enums.CodeEnums;
import me.spokenbot.model.response.CommonResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String json = JSONUtil.toJsonPrettyStr(CommonResponse.with(CodeEnums.AUTHORIZE_FAILED));
        response.getWriter().println(json);
    }
}
