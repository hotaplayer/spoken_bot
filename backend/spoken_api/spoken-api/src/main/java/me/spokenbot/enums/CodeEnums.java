package me.spokenbot.enums;

import lombok.Getter;

@Getter
public enum CodeEnums {

    SUCCESS("0", null),
    USER_NOT_FOUND("10001", "User Not Found"),
    INVALID_PASSWORD("10002", "Invalid Password"),
    AUTHENTICATE_FAILED("10003", "User authentication failed"),

    AUTHORIZE_FAILED("10004", "User authorize failed"),

    DUPLICATE_USER("10005", "Duplicate user"),

    REQUEST_ERROR("99999", "Request failed");
    private String code;
    private String message;

    CodeEnums(String code, String message){
        this.code = code;
        this.message = message;
    }
}
