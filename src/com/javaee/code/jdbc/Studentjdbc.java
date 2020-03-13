package com.javaee.code.jdbc;

import com.javaee.code.model.Student;
import com.javaee.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/13 16:38
 */
public class Studentjdbc {

    private static  String url = "jdbc:mysql://127.0.0.1:3306/school";
    private static String driveName = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        List<Student> list = selectAll();
        for(Student s:list){
            System.out.println(s.getName());
        }
    }

    /**
     *
     *查询所有学生
     *
     */
    public static List<Student> selectAll(){
        String sqlString = "select * from s_student";
        List<Student> list = new ArrayList<Student>();
        //创建连接
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,"root","root")){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        Student s = new Student();
                        s.setId(resultSet.getLong("id"));
                        s.setName(resultSet.getString("name"));
                        s.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(s);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 添加学生
     *
     */
    public static boolean addStudent(Student s){
        String sqlString = "insert into s_student(id,name,create_time) values(?,?,?)";
        //创建驱动
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(url,"root","root")){
            try(PreparedStatement ps = connection.prepareStatement(sqlString)){
                ps.setLong(1,s.getId());
                ps.setString(2,s.getName());
                ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  false;
    }
}
