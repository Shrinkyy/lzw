package com.iweb.dao;

import com.iweb.DBUtil.DBUtil;
import com.iweb.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/11 16:56
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void insert(User user) {
            String sql = "INSERT INTO user (name, tel, sex, part,passName,passWord) VALUES (?, ?, ?, ?,?,?)";
            try(
                    Connection conn = DBUtil.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ){
                ps.setString(1, user.getName());
                ps.setString(2, user.getTel());
                ps.setString(3, user.getSex());
                ps.setString(4, user.getPart());
                ps.setString(5, user.getPassName());
                ps.setString(6, user.getPassWord());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    user.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name=?, tel=?, sex=?, part=? WHERE id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setString(2,user.getTel());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getPart());
            ps.setInt(5,user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        if(user.getId()!=0 & user.getName()==null){
            String sql = "delete from user where id = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setInt(1,user.getId());
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else if(user.getId()==0 & user.getName()!=null){
            String sql = "delete from user where name = ?";
            try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
                ps.setString(1,user.getName());
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
    public User get(int id) {
        User user = null;
        String sql = "select * from user where id = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                String name = rs.getString("name");
                user.setId(id);
                user.setName(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public List<User> listByNameLike(String key) {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user where name like concat('%',?,'%')";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt("id"),rs.getString("name"), rs.getString("tel"),rs.getString("sex"),
                        rs.getString("part"),rs.getString("passName"),rs.getString("passWord"));
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList.size() == 0 ? null : userList;
    }
}
