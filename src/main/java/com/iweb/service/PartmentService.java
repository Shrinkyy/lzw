package com.iweb.service;

import com.iweb.dao.PartmentDaoImpl;
import com.iweb.pojo.Partment;
import com.iweb.view.PartmentView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 22:28
 */
public class PartmentService {
    private static Scanner sc = new Scanner(System.in);
    public static void partmentInsert(){
        System.out.println("输入插入的部门编号");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入插入的部门名称");
        String name = sc.nextLine();
        Partment partment = new Partment(id,name);
        PartmentDaoImpl partmentDao = new PartmentDaoImpl();
        partmentDao.insert(partment);
        PartmentView.alterPartmentMessage();
    }
    public static void partmentDelete(){
        System.out.println("输入删除的部门编号");
        int id = Integer.parseInt(sc.nextLine());
        Partment partment = new Partment();
        partment.setId(id);
        PartmentDaoImpl partmentDao = new PartmentDaoImpl();
        partmentDao.delete(partment);
        PartmentView.alterPartmentMessage();
    }
    public static void partmentAlter(){
        System.out.println("输入要改变的部门id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入要改变部门的名称");
        String name = sc.nextLine();
        Partment partment = new Partment();
        partment.setId(id);
        partment.setName(name);
        PartmentDaoImpl partmentDao = new PartmentDaoImpl();
        partmentDao.update(partment);
        PartmentView.alterPartmentMessage();
    }
    public static void partmentFind(){
        System.out.println("请输入要查询的部门名称关键字：");
        String keyword = sc.nextLine();
        PartmentDaoImpl partmentDao = new PartmentDaoImpl();
        List<Partment> partmentList = partmentDao.listByNameLike(keyword);
        if (partmentList != null && partmentList.size() > 0) {
            for (Partment partment : partmentList) {
                System.out.println(partment);
            }
        } else {
            System.out.println("没有匹配的结果");
        }
        PartmentView.alterPartmentMessage();
    }
}
