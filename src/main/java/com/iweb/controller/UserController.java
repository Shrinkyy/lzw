package com.iweb.controller;

import com.iweb.service.UserService;
import com.iweb.view.MainView;
import com.iweb.view.UserView;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 15:45
 */
public class UserController {
    public static void alterPersonMessageController(String key) {
        switch (key) {
            case "1":
                System.out.println("即将跳转到插入数据信息页面...");
                UserView.UserInsertView();
                break;
            case "2":
                System.out.println("即将跳转到删除数据信息页面...");
                UserView.UserDeletetView();
                break;
            case "3":
                System.out.println("即将跳转到修改数据信息页面...");
                UserView.UserAlterView();
                break;
            case "4":
                System.out.println("即将跳转到查找数据信息页面...");
                UserView.UserFindView();
                break;
            case "5":
                //返回上一级
                MainView.loginSuccessView();
                break;
            default:
                System.out.println("输入范围错误");
                break;
        }
    }
}
