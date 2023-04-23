package me.spokenbot.advice;

import lombok.extern.slf4j.Slf4j;
import me.spokenbot.enums.CodeEnums;
import me.spokenbot.errors.SpokenBotException;
import me.spokenbot.model.response.CommonResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(SpokenBotException.class)
    public CommonResponse handleSpokenBotException(HttpServletRequest req, SpokenBotException e) {
        CodeEnums codeEnums = e.getCodeEnums();
        return CommonResponse.with(codeEnums);
    }

    @ExceptionHandler(AuthenticationException.class)
    public CommonResponse handleAuthenticationException(HttpServletRequest req, AuthenticationException e) {
        log.error("AuthenticationException ",e);
        if (e instanceof UsernameNotFoundException) {
            return CommonResponse.with(CodeEnums.USER_NOT_FOUND);
        }
        if (e instanceof BadCredentialsException){
            return CommonResponse.with(CodeEnums.INVALID_PASSWORD);
        }
        return new CommonResponse(CodeEnums.AUTHENTICATE_FAILED.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handleAuthenticationException(HttpServletRequest req, Exception e) {
        log.error("Exception ",e);
        return new CommonResponse(CodeEnums.REQUEST_ERROR.getCode(), e.getMessage(), null);
    }

}
