package com.iweb.service;

import com.iweb.DBUtil.Data;
import com.iweb.Main;
import com.iweb.dao.UserDaoImpl;
import com.iweb.pojo.User;

import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 10:34
 */
public class MainService {
    public static boolean login(User inputUser){
        boolean isLogin = false;
        List<User> userList = Data.getUsers();
        for (User user : userList) {
            if(user.getPassName().equals(inputUser.getPassName())
            &&user.getPassWord().equals(inputUser.getPassWord())){
                isLogin = true;
            }
        }
        return isLogin;
    }
}
