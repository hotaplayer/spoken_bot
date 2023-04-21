package me.spokenbot.errors;

import lombok.Getter;
import me.spokenbot.enums.CodeEnums;

@Getter
public class SpokenBotException extends RuntimeException{

    private CodeEnums codeEnums;

    public SpokenBotException(CodeEnums codeEnums){
        super(codeEnums.getMessage());
        this.codeEnums = codeEnums;
    }
}
