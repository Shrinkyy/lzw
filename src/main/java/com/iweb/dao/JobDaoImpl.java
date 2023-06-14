package com.iweb.dao;

import com.iweb.DBUtil.DBUtil;
import com.iweb.pojo.Document;
import com.iweb.pojo.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/14 15:31
 */
public class JobDaoImpl implements JobDao {
    @Override
    public void insert(Job job) {
        String sql = "insert into job(name) values(?)";
        try(
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1,job.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                job.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Job job) {
        String sql = "update job set name = ? where id = ?";
        try(Connection c  = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,job.getName());
            ps.setInt(2,job.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Job job) {
        if(job.getId() != 0 & job.getName() == null){
            String sql = "delete from job where id = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setInt(1,job.getId());
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else if(job.getId()==0 & job.getName()!=null){
            String sql = "delete from job where name = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setString(1,job.getName());
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
    public Job get(int id) {
        Job job = null;
        String sql = "select * from job where id = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                job = new Job();
                String name = rs.getString("name");
                job.setId(id);
                job.setName(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return job;
    }

    @Override
    public List<Job> listByNameLike(String key) {
        List<Job> jobList = new ArrayList<>();
        String sql = "select * from job where name like concat('%',?,'%')";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Job job = new Job(rs.getInt("id"),rs.getString("name"));
                jobList.add(job);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return jobList.size() == 0 ? null : jobList;
    }
}
