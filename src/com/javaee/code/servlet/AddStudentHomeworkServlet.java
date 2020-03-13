package com.javaee.code.servlet;

import com.javaee.code.jdbc.StudentHomeworkjdbc;
import com.javaee.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/11 20:47
 */
@WebServlet("/submit")
public class AddStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentHomework sh = new StudentHomework();
        //¸³Öµ
        req.setCharacterEncoding("utf-8");
        sh.setStudentId(Long.valueOf(req.getParameter("student_id")));
        sh.setHomeworkId(Long.valueOf(req.getParameter("homework_id")));
        sh.setHomeworkTitle(String.valueOf(req.getParameter("homework_title")));
        sh.setHomeworkContent(String.valueOf(req.getParameter("homework_content")));

        StudentHomeworkjdbc.addStudentHomework(sh);
        resp.sendRedirect("main");
    }
}
