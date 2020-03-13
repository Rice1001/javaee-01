<%--
  Created by IntelliJ IDEA.
  User: Rice
  Date: 2020/3/13
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理</title>
</head>
<body>
    <div>
        <h1 align="center">学生作业管理系统</h1>
        <form method="post" action="/addStudent">
            <fieldset>
                <legend> 添加学生</legend>
                <br>
                student id: <input type="text" name="id">
                <br />
                student name: <input type="text" name="name" />
                <br>
                <input type="submit" value="Submit" />
            </fieldset>
        </form>
        <br>
        <br>
        <form method="post" action="/addHomework">
            <fieldset>
                <legend> 添加作业</legend>
                <br>
                homework id: <input type="text" name="id" />
                <br />
                homework title: <input type="text" name="title" />
                <br />
                homework content: <input type="text" name="content" />
                <br />
                <input type="submit" value="Submit" />
                <br>
            </fieldset>
        </form>

    </div>

</body>
</html>
