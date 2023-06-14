package com.iweb.DBUtil;

import com.iweb.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 11:07
 */
public class Data {
    private static List<User> userList;
    //    count用来记录我们当前数组中用户的数量
    private static Integer count;
    //在java代码一次运行的期间内,只有当前Data类第一次
    //被使用(加载)的时候,才会运行
    static {
        init();
    }

    public static List<User> getUsers() {
        return userList;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Data.count = count;
    }


    public static void init(){
        userList = new ArrayList<>(); //创建集合对象

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String URL = "jdbc:mysql://localhost:3306/lzw?characterEncoding=utf-8";
        String USERNAME = "root";
        final String PASSWORD = "123456";

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            //连接到数据库
            String sql = "SELECT * FROM user ";
            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                //执行查询
                try(ResultSet rs = ps.executeQuery()) {
                    //处理结果集
                    while(rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String tel = rs.getString("tel");
                        String sex = rs.getString("sex");
                        String part = rs.getString("part");
                        String passName = rs.getString("passName");
                        String passWord = rs.getString("passWord");

                        User user = new User(id,name,tel,sex,part,passName,passWord); //创建User对象
                        userList.add(user); //添加到集合中
                        count = rs.last() ? rs.getRow() : 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
