package com.javaee.code.servlet;

import com.javaee.code.jdbc.Homeworkjdbc;
import com.javaee.code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rice
 * @version 1.0
 * @date 2020/3/13 19:44
 */

@WebServlet("/addHomework")
public class AddHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Homework hm = new Homework();

        req.setCharacterEncoding("UTF-8");
        hm.setId(Long.valueOf(req.getParameter("id")));
        hm.setTitle(String.valueOf(req.getParameter("title")));
        hm.setContent(String.valueOf(req.getParameter("content")));

        //Êý¾Ý²åÈë
        if(Homeworkjdbc.addHomework(hm)){
            resp.getWriter().println("successfully add");
        }

    }
}
