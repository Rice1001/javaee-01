package com.javaee.code.servlet;

import com.javaee.code.jdbc.Studentjdbc;
import com.javaee.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/13 17:16
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        //����������뷽ʽ
        req.setCharacterEncoding("UTF-8");
        //��ֵ
        s.setId(Long.valueOf(req.getParameter("id")));
        s.setName(String.valueOf(req.getParameter("name")));
        //���ݲ���
        if(Studentjdbc.addStudent(s))
            resp.getWriter().println("successfully add!");

    }
}
