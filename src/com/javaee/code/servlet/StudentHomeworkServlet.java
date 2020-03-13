package com.javaee.code.servlet;

import com.javaee.code.jdbc.StudentHomeworkjdbc;
import com.javaee.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/11 20:47
 */
@WebServlet("/list")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = StudentHomeworkjdbc.selectAll();
        req.setAttribute("list",list);

        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
