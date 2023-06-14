package com.iweb.view;

import com.iweb.DBUtil.StringUtil;
import com.iweb.controller.MainController;
import com.iweb.controller.UserController;
import com.iweb.pojo.User;
import com.iweb.service.MainService;
import com.iweb.service.UserService;

import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/11 14:18
 */
public class MainView {
    public static Scanner sc = new Scanner(System.in);
    public static void mainView(){
        System.out.println("欢迎来到阿伟的人事管理系统");
        System.out.println("输入你的选项");
        System.out.println("1:登录");
        System.out.println("2:注册");
        System.out.println("3:退出");
        String mainInputKey = sc.nextLine();
        MainController.mainController(mainInputKey);
    }
    public static void loginView(){
        System.out.println("输入登陆的用户名:");
        String inputPassName = sc.nextLine();
        System.out.println("输入登录密码:");
        String inputPassword = sc.nextLine();
        //将获取的输入信息封装成对象
        User inputUser = new User();
        inputUser.setPassName(inputPassName);
        inputUser.setPassWord(inputPassword);
        //获取验证码:如果发现验证码不对 则直接重新登录
        String confirmCode = StringUtil.getRandomString();
        System.out.println("验证码为:"+confirmCode+",请输入验证码进行验证,验证码不区分大小写");
        String inputConfirmCode = sc.nextLine();
        if(confirmCode.equalsIgnoreCase(inputConfirmCode)){
//            如果发现验证码验证通过,则进行验证 在进入到后续流程
            System.out.println("验证码通过,正在验证用户名和密码,请稍后...");
            //视图层应该将上面的inputUser传递给业务方法 根据业务方法判断用户是否登录成功
            boolean isLogin = MainService.login(inputUser);
            //如果登录成功,则跳转到下一级页面
            if(isLogin){
                //跳转到下一级页面
                loginSuccessView();
            }else {
                //否则 重新访问登录页面
                System.out.println("密码或用户名错误");
                loginView();
            }

        }else {
            //直接要求用户重新输入用户名 密码 新的验证码
            System.out.println("验证码输入有误,请重新输入!");
            loginView();
        }
    }
    public static void loginSuccessView(){
        System.out.println("请输入你想访问的功能");
        System.out.println("1.修改个人信息");
        System.out.println("2.修改部门信息");
        System.out.println("3.修改公告信息");
        System.out.println("4.修改职位信息");
        System.out.println("5.返回上一级");
        String inputKey = sc.nextLine();
        //将输入的数据交给下一层控制器处理
        MainController.loginSuccessController(inputKey);
    }
    public static void registerView(){
        UserService.UserInsert();
    }

}
