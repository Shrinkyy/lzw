package com.iweb.view;

import com.iweb.controller.PartmentController;
import com.iweb.controller.UserController;
import com.iweb.service.PartmentService;

import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 16:13
 */
public class PartmentView {
    public static Scanner sc = new Scanner(System.in);
    public static void alterPartmentMessage(){
        System.out.println("请输入你想访问的功能");
        System.out.println("1、插入数据");
        System.out.println("2、删除数据");
        System.out.println("3、修改数据");
        System.out.println("4、查找数据");
        System.out.println("5、返回上一级");
        String inputKey = sc.nextLine();
        PartmentController.alterPartmentMessageController(inputKey);
    }
    public static void partmentInsertView(){
        System.out.println("即将跳转至部门插入界面");
        PartmentService.partmentInsert();
    }
    public static void partmentDeleteView(){
        System.out.println("即将跳转至部门删除界面");
        PartmentService.partmentDelete();
    }
    public static void partmentAlterView(){
        System.out.println("即将跳转至部门修改界面");
        PartmentService.partmentAlter();
    }
    public static void partmentFindView(){
        System.out.println("即将跳转至部门查询界面");
        PartmentService.partmentFind();
    }
}
