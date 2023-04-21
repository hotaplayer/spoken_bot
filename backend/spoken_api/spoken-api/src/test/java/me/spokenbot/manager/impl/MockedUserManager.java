package me.spokenbot.manager.impl;

import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserInfoBO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
@Primary
public class MockedUserManager implements IUserManager {

    private HashMap<String, UserInfoBO> storage = new HashMap<>();

    @Override
    public long save(UserInfoBO userRegisterBO) {
        storage.put(userRegisterBO.getUsername(), userRegisterBO);
        return 1;
    }

    @Override
    public UserInfoBO loadUserInfoByName(String username) {
        return storage.get(username);
    }
}
