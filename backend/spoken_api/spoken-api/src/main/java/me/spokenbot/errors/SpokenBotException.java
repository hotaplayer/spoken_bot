package me.spokenbot.errors;

import me.spokenbot.enums.CodeEnums;

public class SpokenBotException extends RuntimeException{

    private CodeEnums codeEnums;

    public SpokenBotException(CodeEnums codeEnums){
        super(codeEnums.getMessage());
        this.codeEnums = codeEnums;
    }
}
