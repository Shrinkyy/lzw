package com.iweb.service;

import com.iweb.dao.UserDaoImpl;
import com.iweb.pojo.User;
import com.iweb.view.MainView;
import com.iweb.view.UserView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 15:55
 */
public class UserService {
    public static Scanner sc = new Scanner(System.in);
    public static void UserInsert(){
        System.out.println("输入插入的数据");
        System.out.println("输入id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入姓名");
        String name = sc.nextLine();
        System.out.println("输入电话");
        String tel = sc.nextLine();
        System.out.println("输入性别");
        String sex = sc.nextLine();
        System.out.println("输入部门");
        String part = sc.nextLine();
        System.out.println("输入用户名");
        String passName = sc.nextLine();
        System.out.println("输入密码");
        String passWord = sc.nextLine();
        User new_user = new User(id,name,tel,sex,part,passName,passWord);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insert(new_user);
        UserView.alterPersonMessage();
    }
    public static void UserDelete(){
        System.out.println("输入要删除用户的id");
        int id = Integer.parseInt(sc.nextLine());
        User user = new User();
        user.setId(id);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.delete(user);
        UserView.alterPersonMessage();
    }
    public static void UserAlter(){
        System.out.println("输入要修改用户的id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入新的姓名1");
        String name = sc.nextLine();
        User user = new User();
        user.setId(id);
        user.setName(name);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.update(user);
        UserView.alterPersonMessage();
    }
    public static void UserFind(){
        System.out.println("输入要查询的用户名");
        String name = sc.nextLine();
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.listByNameLike(name);
        if (userList != null && userList.size() > 0) {
            for (User user : userList) {
                System.out.println(user);
            }
        } else {
            System.out.println("没有匹配的结果");
        }
        UserView.alterPersonMessage();
    }
}
