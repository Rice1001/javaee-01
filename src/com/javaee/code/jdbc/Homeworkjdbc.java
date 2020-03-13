package com.javaee.code.jdbc;

import com.javaee.code.model.Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/13 19:35
 */
public class Homeworkjdbc {

    private static  String url = "jdbc:mysql://127.0.0.1:3306/school";
    private static String driveName = "com.mysql.cj.jdbc.Driver";

    /**
     * 查询添加的作业
     *
     */

    public static List<Homework> selectAll(){
        String sqlString = "select * from s_homework";
        List<Homework> list = new ArrayList<Homework>();
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(url,"root","root")){
            try(Statement statement = connection.createStatement()){
                try(ResultSet rs = statement.executeQuery(sqlString)){
                   while(rs.next()){
                       Homework hm = new Homework();
                       hm.setId(rs.getLong("id"));
                       hm.setTitle(rs.getString("title"));
                       hm.setContent(rs.getString("content"));
                       hm.setCreate_time(rs.getTimestamp("create_time"));
                       list.add(hm);
                   }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }


    /**
     *
     * 添加作业
     */
    public static boolean addHomework(Homework hm)  {
        String sqlString = "insert into s_homework(id, title,content, create_time) values(?,?,?,?)";
        //创建驱动
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,"root","root")){
            try(PreparedStatement ps = connection.prepareStatement(sqlString)){
                ps.setLong(1,hm.getId());
                ps.setString(2,hm.getTitle());
                ps.setString(3,hm.getContent());
                ps.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
