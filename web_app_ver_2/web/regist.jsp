<%--
  Created by IntelliJ IDEA.
  User: qiuchunliu
  Date: 2019/4/14
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

    <h1>
        注册中。。。
    </h1><br>
    <h1>
        ${error}
    </h1>
    <form action="registServlet" method="post">
        用户名称：<input type="text" name="username" /><br>
        用户密码：<input type="password" name="password" /><br>
        <input type="submit" value="注册" />
    </form>
</body>
</html>
