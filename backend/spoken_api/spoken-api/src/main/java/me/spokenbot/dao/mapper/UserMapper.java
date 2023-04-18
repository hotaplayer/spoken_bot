package me.spokenbot.dao.mapper;

import me.spokenbot.dao.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Insert("INSERT INTO t_user_info (`username`,`pwd_hash`,`role`, `is_delete`, `create_time`, `update_time`) VALUES()")
    int insert();

    @Select("SELECT * FROM t_user_info")
    @ResultType(UserMapper.class)
    UserInfoEntity select();

}
