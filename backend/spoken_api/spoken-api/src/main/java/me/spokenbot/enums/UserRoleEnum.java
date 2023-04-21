package me.spokenbot.enums;

import lombok.Getter;
import org.fisco.bcos.sdk.v3.codec.datatypes.Int;

import java.util.HashMap;

@Getter
public enum UserRoleEnum {

    Admin(0, "admin"),

    OpenAI(1, "openAI"),

    Normal(2, "normal");

    private static HashMap<Integer, UserRoleEnum> idToRoles = new HashMap<>();

    static {
        for (UserRoleEnum role: UserRoleEnum.values()){
            idToRoles.put(role.getRoleKey(), role);
        }
    }

    private int roleKey;
    private String roleName;

    UserRoleEnum(int roleKey, String roleName){
        this.roleKey = roleKey;
        this.roleName = roleName;
    }

    public static UserRoleEnum findByRoleKey(int role) {
        return idToRoles.get(role);
    }
}
