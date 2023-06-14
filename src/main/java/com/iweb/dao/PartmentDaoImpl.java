package com.iweb.dao;

import com.iweb.DBUtil.DBUtil;
import com.iweb.pojo.Partment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 8:54
 */
public class PartmentDaoImpl implements PartmentDao{
    @Override
    public void insert(Partment partment) {
        String sql = "insert into partment(name) values(?)";
        try(
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ) {
            ps.setString(1,partment.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                partment.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Partment partment) {
        String sql = "update partment set name = ? where id = ?";
        try(Connection c  = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,partment.getName());
            ps.setInt(2,partment.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Partment partment) {
        if(partment.getId()!=0 & partment.getName()==null){
            String sql = "delete from partment where id = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setInt(1,partment.getId());
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else if(partment.getId()==0 & partment.getName()!=null){
            String sql = "delete from partment where name = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setString(1,partment.getName());
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
    public Partment get(int id) {
        Partment partment = null;
        String sql = "select * from partment where id = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                partment = new Partment();
                String name = rs.getString("name");
                partment.setId(id);
                partment.setName(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return partment;
    }

    @Override
    public List<Partment> listByNameLike(String key) {
        List<Partment> partmentList = new ArrayList<>();
        String sql = "select * from partment where name like concat('%',?,'%')";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Partment partment = new Partment(rs.getInt("id"),rs.getString("name"));
                partmentList.add(partment);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return partmentList.size() == 0 ? null : partmentList;
    }
}
