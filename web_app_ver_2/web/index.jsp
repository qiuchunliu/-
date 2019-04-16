<%--
  Created by IntelliJ IDEA.
  User: qiuchunliu
  Date: 2019/4/14
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <h1>
            图书借阅系统
        </h1><br>
        <h1>
            ${error}
        </h1>
        <form action="loginServlet" method="post">
          登录账号：<input type="text" name="username" /><br>
          登录密码：<input type="password" name="password" /><br>
          <input type="submit" value="登陆" />        <a href="regist.jsp">注册</a>
        </form>
  </body>
</html>
