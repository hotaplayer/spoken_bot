package me.spokenbot.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class CommonEntity {

    private boolean isDelete;

    private Date createTime;

    private Date updateTime;

}
