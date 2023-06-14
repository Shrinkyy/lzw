package com.iweb.service;

import com.iweb.dao.DocumentDaoImpl;
import com.iweb.dao.JobDaoImpl;
import com.iweb.pojo.Document;
import com.iweb.pojo.Job;
import com.iweb.view.DocumentView;
import com.iweb.view.JobView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/14 14:58
 */
public class JobService {
    private static Scanner sc = new Scanner(System.in);
    public static void jobInsert(){
        System.out.println("输入插入的职位编号");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入插入的职位内容");
        String name = sc.nextLine();
        Job job = new Job(id,name);
        JobDaoImpl jobDao = new JobDaoImpl();
        jobDao.insert(job);
        JobView.alterJobMessage();
    }
    public static void jobDelete(){
        System.out.println("输入删除的职位编号");
        int id = Integer.parseInt(sc.nextLine());
        Job job = new Job();
        job.setId(id);
        JobDaoImpl jobDao = new JobDaoImpl();
        jobDao.delete(job);
        JobView.alterJobMessage();
    }
    public static void jobAlter(){
        System.out.println("输入要改变的职位id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入要改变职位的内容");
        String name = sc.nextLine();
        Job job = new Job();
        job.setId(id);
        job.setName(name);
        JobDaoImpl jobDao = new JobDaoImpl();
        jobDao.update(job);
        JobView.alterJobMessage();
    }
    public static void jobFind(){
        System.out.println("请输入要查询的职位内容关键字：");
        String keyword = sc.nextLine();
        JobDaoImpl jobDao = new JobDaoImpl();
        List<Job> jobList = jobDao.listByNameLike(keyword);
        if (jobList != null && jobList.size() > 0) {
            for (Job job : jobList) {
                System.out.println(job);
            }
        } else {
            System.out.println("没有匹配的结果");
        }
        JobView.alterJobMessage();
    }
}
