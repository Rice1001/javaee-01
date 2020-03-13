package com.javaee.code.jdbc;

import java.sql.*;

public class TestJdbcV3 {

    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String driveName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "select *from pet limit 5";
        try{
            //创建驱动
            Class.forName(driveName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //连接mysql获取数据,获取完毕以后关闭mysql连接
        int n= 100;
        while(n-- >= 0){
            try(Connection connection = DriverManager.getConnection(url,"root", "root")){
                try( Statement statement = connection.createStatement()){
                    try(ResultSet resultSet = statement.executeQuery(sqlString)){
                        while(resultSet.next()){
                            System.out.println(resultSet.getString(1));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  null;
    }

    public static void main(String[] args){
        getMysql();
    }
}
