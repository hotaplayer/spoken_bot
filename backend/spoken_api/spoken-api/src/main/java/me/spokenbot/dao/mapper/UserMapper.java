package me.spokenbot.dao.mapper;

import me.spokenbot.dao.entity.UserInfoEntity;
import me.spokenbot.model.bo.UserInfoBO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {


    @Insert("INSERT INTO t_user_info (`username`,`pwd_hash`,`role`) " +
            "VALUES(#{username}, #{pwdHash}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserInfoEntity entity);


    @Select("SELECT * FROM t_user_info WHERE username=#{username}")
    @ResultType(UserInfoEntity.class)
    UserInfoEntity selectByUsername(String username);
}
