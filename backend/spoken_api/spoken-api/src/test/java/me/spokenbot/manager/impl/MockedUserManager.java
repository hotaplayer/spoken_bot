package me.spokenbot.manager.impl;

import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserRegisterBO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


public class MockedUserManager implements IUserManager {

    private Set<UserRegisterBO> storage = new HashSet<>();

    @Override
    public long save(UserRegisterBO userRegisterBO) {
        storage.add(userRegisterBO);
        return 1;
    }
}
