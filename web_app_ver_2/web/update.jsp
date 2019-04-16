<%--
  Created by IntelliJ IDEA.
  User: qiuchunliu
  Date: 2019/4/14
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="updateServlet" method="get">
        用户id ：<input type="text" name="id" /><br>
        用户名称：<input type="text" name="username" /><br>
        用户密码：<input type="password" name="password" /><br>
        <input type="submit" value="修改" />
    </form>
</body>
</html>
