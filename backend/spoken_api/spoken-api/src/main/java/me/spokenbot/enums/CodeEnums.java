package me.spokenbot.enums;

import lombok.Getter;

@Getter
public enum CodeEnums {

    SUCCESS("0", null),
    USER_NOT_FOUND("10001", "User Not Found");

    private String code;
    private String message;

    CodeEnums(String code, String message){
        this.code = code;
        this.message = message;
    }
}
