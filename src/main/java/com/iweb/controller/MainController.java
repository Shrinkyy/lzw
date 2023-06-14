package com.iweb.controller;

import com.iweb.dao.UserDao;
import com.iweb.dao.UserDaoImpl;
import com.iweb.view.*;

/**
 * @Author 娄志伟
 * @Create 2023/6/11 14:51
 */
public class MainController {
    public static void mainController(String key){
        //根据key的值 决定后续跳转的页面
        switch (key){
            case "1":
                System.out.println("即将跳转至登陆界面...");
                MainView.loginView();
                break;
            case "2":
                System.out.println("即将跳转至注册界面...");
                MainView.registerView();
                break;
            case "3":
                System.out.println("即将退出...");
                break;
            default:
                System.out.println("输入有误，重新输入");
                MainView.mainView();
        }
    }
    public static void loginSuccessController(String key){
        switch (key){
            case "1":
                System.out.println("即将跳转到修改个人信息页面...");
                UserView.alterPersonMessage();
                break;
            case "2":
                System.out.println("即将跳转到修改部门信息页面...");
                PartmentView.alterPartmentMessage();
                break;
            case "3":
                System.out.println("即将跳转到修改公告信息页面...");
                DocumentView.alterDocumentMessage();
                break;
            case "4":
                System.out.println("即将跳转到修改职位信息页面...");
                JobView.alterJobMessage();
                break;
            case "5":
                //返回上一级
                MainView.loginView();
                break;
            default:
                System.out.println("输入范围错误");
                break;
        }
    }
}
