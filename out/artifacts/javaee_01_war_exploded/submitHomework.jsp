<%@ page import="com.javaee.code.model.Homework" %>
<%@ page import="com.javaee.code.jdbc.Homeworkjdbc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rice
  Date: 2020/3/13
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
    <div align="center">
        <br />
        <br />
        <br />
        <table align="center" width = "960" border="1" bgcolor="#f0f8ff" cellpadding="1" cellspacing="1">
            <tr align="center" height = "35" bgcolor="#ffe4c4">
                <td>作业编号</td>
                <td>作业标题</td>
                <td>作业内容</td>
                <td>创建时间</td>
            </tr>
                <%
        List<Homework> list = Homeworkjdbc.selectAll();

        if(list == null){
          out.println("none data");
        }else{
          for(Homework hm :list){
      %>
            <tr align="center" >
                <td><%=hm.getId()%></td>
                <td><%=hm.getTitle()%></td>
                <td><%=hm.getContent()%></td>
                <td><%=hm.getCreate_time()%></td>
            </tr>
                <%
        }
      }
      %>

         <form method="post" action="/submit">
             <fieldset>
                 <legend>提交作业</legend>
                 <br>
                 student id: <input type="text" name="student_id">
                 <br />
                 homework id: <input type="text" name="homework_id" />
                 <br />
                 homework title: <input type="text" name="homework_title" />
                 <br />
                 homework content: <input type="text" name="homework_content" />
                 <br />
                 <input type="submit" value="Submit" />
             </fieldset>
     </form>
    </div>
</body>
</html>
