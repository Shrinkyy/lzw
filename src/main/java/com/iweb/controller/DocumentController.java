package com.iweb.controller;

import com.iweb.view.DocumentView;
import com.iweb.view.MainView;
import com.iweb.view.PartmentView;

/**
 * @Author 娄志伟
 * @Create 2023/6/13 11:29
 */
public class DocumentController {
    public static void alterDocumentMessageController(String key) {
        switch (key) {
            case "1":
                System.out.println("即将跳转到插入部门信息页面...");
                DocumentView.documentInsertView();
                break;
            case "2":
                System.out.println("即将跳转到删除部门信息页面...");
                DocumentView.documentDeleteView();
                break;
            case "3":
                System.out.println("即将跳转到修改部门信息页面...");
                DocumentView.documentAlterView();
                break;
            case "4":
                System.out.println("即将跳转到查找数据信息页面...");
                DocumentView.documentFindView();
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
