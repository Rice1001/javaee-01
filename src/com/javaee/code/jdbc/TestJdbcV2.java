package com.javaee.code.jdbc;

import java.sql.*;

/**
 *
 * 手动关闭创建的mysql连接
 */
public class TestJdbcV2 {

    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String driveName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "select *from pet limit 5";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet =null;

        try{
            //创建驱动
            Class.forName(driveName);
            //建立连接
            connection = DriverManager.getConnection(url,"root", "root");
            //创建语句
            statement = connection.createStatement();
            //执行查询并返回结果
            resultSet = statement.executeQuery(sqlString);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return  null;
    }

    public static void main(String[] args){
        getMysql();
    }
}
