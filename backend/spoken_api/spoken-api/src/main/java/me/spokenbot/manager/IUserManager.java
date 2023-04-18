package me.spokenbot.manager;

import me.spokenbot.model.bo.UserRegisterBO;

//这一层只为抽象，提供多种实现，这对测试和扩展性都有好处
public interface IUserManager {

    long save(UserRegisterBO userRegisterBO);

}
