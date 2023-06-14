package com.iweb.controller;

import com.iweb.view.DocumentView;
import com.iweb.view.JobView;
import com.iweb.view.MainView;

/**
 * @Author 娄志伟
 * @Create 2023/6/14 14:48
 */
public class JobController {
    public static void alterJobMessageController(String key) {
        switch (key) {
            case "1":
                System.out.println("即将跳转到插入职位信息页面...");
                JobView.jobInsertView();
                break;
            case "2":
                System.out.println("即将跳转到删除职位信息页面...");
                JobView.jobDeleteView();
                break;
            case "3":
                System.out.println("即将跳转到修改职位信息页面...");
                JobView.jobAlterView();
                break;
            case "4":
                System.out.println("即将跳转到查找职位信息页面...");
                JobView.jobFindView();
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
