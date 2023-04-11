package me.spokenbot.errors;

import lombok.Getter;

@Getter
public enum CodeEnums {

    SUCCESS("0", null);

    private String code;
    private String message;

    CodeEnums(String code, String message){
        this.code = code;
        this.message = message;
    }
}
