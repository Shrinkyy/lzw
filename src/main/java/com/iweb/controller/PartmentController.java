package com.iweb.controller;

import com.iweb.view.MainView;
import com.iweb.view.PartmentView;
import com.iweb.view.UserView;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 21:47
 */
public class PartmentController {
    public static void alterPartmentMessageController(String key) {
        switch (key) {
            case "1":
                System.out.println("即将跳转到插入部门信息页面...");
                PartmentView.partmentInsertView();
                break;
            case "2":
                System.out.println("即将跳转到删除部门信息页面...");
                PartmentView.partmentDeleteView();
                break;
            case "3":
                System.out.println("即将跳转到修改部门信息页面...");
                PartmentView.partmentAlterView();
                break;
            case "4":
                System.out.println("即将跳转到查找数据信息页面...");
                PartmentView.partmentFindView();
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
