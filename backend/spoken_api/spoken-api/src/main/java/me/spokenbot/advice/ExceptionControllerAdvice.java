package me.spokenbot.advice;

import lombok.extern.slf4j.Slf4j;
import me.spokenbot.enums.CodeEnums;
import me.spokenbot.errors.SpokenBotException;
import me.spokenbot.handler.CustomAccessDeniedHandler;
import me.spokenbot.model.response.CommonResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(SpokenBotException.class)
    @ResponseBody
    public CommonResponse handleSpokenBotException(HttpServletRequest req, SpokenBotException e) {
        CodeEnums codeEnums = e.getCodeEnums();
        return CommonResponse.with(codeEnums);
    }

//    @ExceptionHandler(AuthenticationException.class)
//    public CommonResponse handleAuthenticationException(HttpServletRequest req, AuthenticationException e) {
//        log.error("AuthenticationException ",e);
//        if (e instanceof UsernameNotFoundException) {
//            return CommonResponse.with(CodeEnums.USER_NOT_FOUND);
//        }
//        if (e instanceof BadCredentialsException){
//            return CommonResponse.with(CodeEnums.INVALID_PASSWORD);
//        }
//        return new CommonResponse(CodeEnums.AUTHENTICATE_FAILED.getCode(), e.getMessage(), null);
//    }


    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody//必须加，不然render会报错
    public CommonResponse handleDupplicateException(HttpServletRequest req, DuplicateKeyException e) {
        log.error("SQLIntegrityConstraintViolationException ",e);
        return new CommonResponse(CodeEnums.DUPLICATE_USER.getCode(),CodeEnums.DUPLICATE_USER.getMessage(), null);
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse handleException(HttpServletRequest req, Exception e) {
        log.error("Exception ",e);
        return new CommonResponse(CodeEnums.REQUEST_ERROR.getCode(), e.getMessage(), null);
    }

}
