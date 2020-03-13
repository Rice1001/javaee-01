package com.javaee.code.jdbc;

import java.sql.*;

public class TestJdbc {

    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String driveName = "com.mysql.cj.jdbc.Driver";
        String sqlString =  "select *from pet limit 5";
        String allurl = url+"?user=root&password=root";
        try{
            //创建驱动
            Class.forName(driveName);
            //建立连接
            Connection connection = DriverManager.getConnection(allurl);
            //创建语句
            Statement statement = connection.createStatement();
            //执行查询并返回结果
            ResultSet resultSet = statement.executeQuery(sqlString);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }


        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args){
        getMysql();
    }
}
