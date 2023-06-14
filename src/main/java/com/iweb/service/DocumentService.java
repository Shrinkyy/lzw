package com.iweb.service;

import com.iweb.dao.DocumentDaoImpl;
import com.iweb.dao.PartmentDaoImpl;
import com.iweb.pojo.Document;
import com.iweb.pojo.Partment;
import com.iweb.view.DocumentView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 娄志伟
 * @Create 2023/6/13 11:49
 */
public class DocumentService {
    private static Scanner sc = new Scanner(System.in);
    public static void documentInsert(){
        System.out.println("输入插入的文件编号");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入插入的文件内容");
        String content = sc.nextLine();
        Document document = new Document(id,content);
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        documentDao.insert(document);
        DocumentView.alterDocumentMessage();
    }
    public static void documentDelete(){
        System.out.println("输入删除的部门编号");
        int id = Integer.parseInt(sc.nextLine());
        Document document = new Document();
        document.setId(id);
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        documentDao.delete(document);
        DocumentView.alterDocumentMessage();
    }
    public static void documentAlter(){
        System.out.println("输入要改变的文件id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("输入要改变文件的内容");
        String content = sc.nextLine();
        Document document = new Document();
        document.setId(id);
        document.setContent(content);
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        documentDao.update(document);
        DocumentView.alterDocumentMessage();
    }
    public static void documentFind(){
        System.out.println("请输入要查询的文件内容关键字：");
        String keyword = sc.nextLine();
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        List<Document> documentList = documentDao.listByNameLike(keyword);
        if (documentList != null && documentList.size() > 0) {
            for (Document document : documentList) {
                System.out.println(document);
            }
        } else {
            System.out.println("没有匹配的结果");
        }
        DocumentView.alterDocumentMessage();
    }
}
