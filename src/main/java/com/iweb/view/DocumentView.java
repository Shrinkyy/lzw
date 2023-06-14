package com.iweb.view;

import com.iweb.controller.DocumentController;
import com.iweb.service.DocumentService;
import com.iweb.service.PartmentService;

import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 16:13
 */
public class DocumentView {
    public static Scanner sc = new Scanner(System.in);
    public static void alterDocumentMessage(){
        System.out.println("请输入你想访问的功能");
        System.out.println("1、插入数据");
        System.out.println("2、删除数据");
        System.out.println("3、修改数据");
        System.out.println("4、查找数据");
        System.out.println("5、返回上级");
        String inputKey = sc.nextLine();
        DocumentController.alterDocumentMessageController(inputKey);
    }
    public static void documentInsertView(){
        System.out.println("即将跳转至文件插入界面");
        DocumentService.documentInsert();
    }
    public static void documentDeleteView(){
        System.out.println("即将跳转至文件删除界面");
        DocumentService.documentDelete();
    }
    public static void documentAlterView(){
        System.out.println("即将跳转至文件修改界面");
        DocumentService.documentAlter();
    }
    public static void documentFindView(){
        System.out.println("即将跳转至文件查询界面");
        DocumentService.documentFind();
    }
}
