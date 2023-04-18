create table t_user_info (
	`pk_id` bigint(20) unsigned not null auto_increment,
    `username` varchar(255) not null comment '用户名称',
    `pwd_hash` varchar(255) not null comment '密码哈希',
    `role` tinyint not null comment '角色, 0-管理员，1-用户, 2-openaiSys， 3-openAi',
    `is_delete` bool not null comment '逻辑删除',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
	primary key (`pk_id`),
	unique key(`username`)
);


create table t_topic_info (
	`pk_id` bigint(20) unsigned not null auto_increment,
    `topic_name` varchar(255) not null comment '主题名称',
    `topic_description` tinytext not null comment '主题描述',
    `is_delete` bool not null comment '逻辑删除',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
	primary key (`pk_id`),
	unique key(`topic_name`)
);

create table t_chat_info (
	`pk_id` bigint(20) unsigned not null auto_increment,
    `topic_id` bigint not null comment '所属主题',
    `chat_role` tinyint not null comment '对话角色，0-sys，1-assistant，2-user',
    `chat_content` tinytext not null comment '谈话内容',
    `is_from_user` bool not null comment '谈话是否源自用户',
    `user_id` bigint not null comment '消息属主',
    `is_delete` bool not null comment '逻辑删除',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
	primary key (`pk_id`)
);
