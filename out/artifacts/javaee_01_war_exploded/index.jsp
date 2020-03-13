<%@ page import="java.util.List" %>
<%@ page import="com.javaee.code.model.StudentHomework" %>
<%@ page import="com.javaee.code.jdbc.StudentHomeworkjdbc" %><%--
  Created by IntelliJ IDEA.
  User: Rice
  Date: 2020/2/27
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>my Homework</title>
  </head>
  <body>
    <table align="center" width = "960" border="1" bgcolor="#f0f8ff" cellpadding="1" cellspacing="1">
      <tr align="center" height = "35" bgcolor="#ffe4c4">
        <td>ID</td>
        <td>学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
      </tr>
      <%
//        List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("list");
        List<StudentHomework> list = StudentHomeworkjdbc.selectAll();

        if(list == null){
          out.println("none data");
        }else{
          for(StudentHomework sh :list){
      %>
      <tr align="center" >
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreateTime()%></td>
      </tr>
      <%
        }
      }
      %>

    </table>
  </body>
</html>
