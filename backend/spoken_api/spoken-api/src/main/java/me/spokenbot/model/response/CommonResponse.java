package me.spokenbot.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.spokenbot.errors.CodeEnums;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private String code;

    private String message;

    private T data;

    public static <T> CommonResponse<T> success(T object){
        CodeEnums successCodeEnum = CodeEnums.SUCCESS;
        return new CommonResponse<>(successCodeEnum.getCode(), successCodeEnum.getMessage(), object);
    }

}
