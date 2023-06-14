package com.iweb.view;

import com.iweb.controller.UserController;
import com.iweb.service.UserService;

import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 16:12
 */
public class UserView {
    public static Scanner sc = new Scanner(System.in);
    public static void alterPersonMessage(){
        System.out.println("请输入你想访问的功能");
        System.out.println("1、插入数据");
        System.out.println("2、删除数据");
        System.out.println("3、修改数据");
        System.out.println("4、查找数据");
        System.out.println("5、返回上级");
        String inputKey = sc.nextLine();
        UserController.alterPersonMessageController(inputKey);
    }
      public static void UserInsertView(){
          System.out.println("跳转至用户插入界面");
          UserService.UserInsert();
      }
    public static void UserDeletetView(){
        System.out.println("跳转至用户删除界面");
        UserService.UserDelete();
    }
    public static void UserAlterView(){
        System.out.println("跳转至用户修改界面");
        UserService.UserAlter();
    }
    public static void UserFindView(){
        System.out.println("跳转至用户查询界面");
        UserService.UserFind();
    }
}
