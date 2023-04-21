package me.spokenbot.enums;

import lombok.Getter;

@Getter
public enum CodeEnums {

    SUCCESS("0", null),
    USER_NOT_FOUND("10001", "User Not Found"),
    INVALID_PASSWORD("10002", "Invalid Password"),
    AUTH_FAILED("10003", "User auth failed"),

    REQUEST_ERROR("99999", "Request failed");
    private String code;
    private String message;

    CodeEnums(String code, String message){
        this.code = code;
        this.message = message;
    }
}
