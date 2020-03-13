package com.javaee.code.jdbc;

import com.javaee.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/11 17:05
 */
public class StudentHomeworkjdbc {

    public static void main(String[] args) {
        List<StudentHomework> list = selectAll();
        for(StudentHomework sh:list){
            System.out.println(sh.getHomeworkContent());
        }
    }


    /**
     * ���ѧ����ҵ
     *
     * @param sh
     */
    public static void addStudentHomework(StudentHomework sh){
        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String driveName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "insert into s_student_homework" +
                "( `student_id`, `homework_id`, `homework_title`, `homework_content`, `create_time`)values (?,?,?,?,?)";
        try{
            //��������
            Class.forName(driveName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,"root", "root")){
            try( PreparedStatement ps = connection.prepareStatement(sqlString)){
                ps.setLong(1,sh.getStudentId());
                ps.setLong(2,sh.getHomeworkId());
                ps.setString(3,sh.getHomeworkTitle());
                ps.setString(4,sh.getHomeworkContent());
                ps.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * ѡ������ѧ������ҵ
     *
     * @return
     */
    public static List<StudentHomework> selectAll(){

        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String driveName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select *from s_student_homework";
        try{
            //��������
            Class.forName(driveName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //����һ���б�����
        List<StudentHomework> list = new ArrayList<StudentHomework>();
        //����mysql��ȡ����,��ȡ����Ժ�ر�mysql����
        try(Connection connection = DriverManager.getConnection(url,"root", "root")){
            try( Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  list;
    }

}
