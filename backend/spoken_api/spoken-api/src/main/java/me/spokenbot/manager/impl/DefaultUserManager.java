package me.spokenbot.manager.impl;

import me.spokenbot.dao.entity.UserInfoEntity;
import me.spokenbot.dao.mapper.UserMapper;
import me.spokenbot.enums.UserRoleEnum;
import me.spokenbot.manager.IUserManager;
import me.spokenbot.model.bo.UserInfoBO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserManager implements IUserManager {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long save(UserInfoBO userRegisterBO) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUsername(userRegisterBO.getUsername());
        userInfoEntity.setPwdHash(userRegisterBO.getPwdHash());
        userInfoEntity.setRole(UserRoleEnum.Normal.getRoleKey());

        userMapper.insert(userInfoEntity);
        userRegisterBO.setId(userInfoEntity.getId());
        return userRegisterBO.getId();
    }

    @Override
    public UserInfoBO loadUserInfoByName(String username) {
        UserInfoEntity userInfoEntity = userMapper.selectByUsername(username);
        if (userInfoEntity == null){
            return null;
        }
        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setId(userInfoEntity.getId());
        userInfoBO.setUsername(username);
        userInfoBO.setRole(UserRoleEnum.findByRoleKey(userInfoEntity.getRole()));
        userInfoBO.setPwdHash(userInfoEntity.getPwdHash());
        userInfoBO.setCreateAt(userInfoEntity.getCreateTime());
        userInfoBO.setCreateAt(userInfoEntity.getCreateTime());
        return userInfoBO;
    }
}
