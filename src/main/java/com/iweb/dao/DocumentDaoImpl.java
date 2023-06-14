package com.iweb.dao;

import com.iweb.DBUtil.DBUtil;
import com.iweb.pojo.Document;
import com.iweb.pojo.Partment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 9:53
 */
public class DocumentDaoImpl implements DocumentDao {
    @Override
    public void insert(Document document) {
        String sql = "insert into document(content) values(?)";
        try(
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1,document.getContent());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                document.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Document document) {
        String sql = "update document set content = ? where id = ?";
        try(Connection c  = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,document.getContent());
            ps.setInt(2,document.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Document document) {
        if(document.getId()!=0 & document.getContent()==null){
            String sql = "delete from document where id = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setInt(1,document.getId());
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else if(document.getId()==0 & document.getContent()!=null){
            String sql = "delete from document where name = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setString(1,document.getContent());
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            try {
                throw new Exception("参数有误");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Document get(int id) {
        Document document = null;
        String sql = "select * from document where id = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                document = new Document();
                String content = rs.getString("content");
                document.setId(id);
                document.setContent(content);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public List<Document> listByNameLike(String key) {
        List<Document> documentList = new ArrayList<>();
        String sql = "select * from document where content like concat('%',?,'%')";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Document document = new Document(rs.getInt("id"),rs.getString("content"));
                documentList.add(document);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return documentList.size() == 0 ? null : documentList;
    }
}
