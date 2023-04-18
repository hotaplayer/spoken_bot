package me.spokenbot.manager.impl;

import cn.hutool.core.date.DateTime;
import me.spokenbot.dao.entity.UserInfoEntity;
import me.spokenbot.dao.mapper.UserMapper;
import me.spokenbot.enums.UserRoleEnum;
import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserRegisterBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DefaultUserManager implements IUserManager {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long save(UserRegisterBO userRegisterBO) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUsername(userRegisterBO.getUsername());
        userInfoEntity.setPwdHash(userRegisterBO.getPwdHash());
        userInfoEntity.setRole(UserRoleEnum.Normal.ordinal());

        userMapper.insert(userInfoEntity);
        userRegisterBO.setId(userInfoEntity.getId());
        return userRegisterBO.getId();
    }
}
