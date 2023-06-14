package com.iweb.view;

import com.iweb.controller.DocumentController;
import com.iweb.controller.JobController;
import com.iweb.service.DocumentService;
import com.iweb.service.JobService;

import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/14 14:45
 */
public class JobView {
    public static Scanner sc = new Scanner(System.in);
    public static void alterJobMessage(){
        System.out.println("请输入你想访问的功能");
        System.out.println("1、插入数据");
        System.out.println("2、删除数据");
        System.out.println("3、修改数据");
        System.out.println("4、查找数据");
        System.out.println("5、返回上级");
        String inputKey = sc.nextLine();
        JobController.alterJobMessageController(inputKey);
    }
    public static void jobInsertView(){
        System.out.println("即将跳转至职位插入界面");
        JobService.jobInsert();
    }
    public static void jobDeleteView(){
        System.out.println("即将跳转至职位删除界面");
        JobService.jobDelete();
    }
    public static void jobAlterView(){
        System.out.println("即将跳转至职位修改界面");
        JobService.jobAlter();
    }
    public static void jobFindView(){
        System.out.println("即将跳转至职位查询界面");
        JobService.jobFind();
    }
}
