package me.spokenbot.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.spokenbot.enums.UserRoleEnum;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoBO {

    private long id;

    private String username;

    private String pwdHash;

    private UserRoleEnum role;

    private Date createAt;

    private Date updateAt;
}
