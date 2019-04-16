<%--
  Created by IntelliJ IDEA.
  User: qiuchunliu
  Date: 2019/4/14
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delet</title>
</head>
<body>
    <form action="deletServlet" method="get">
        要删除的 id ：<input type="text" name="id_to_delet" /><br>
        <input type="submit" value="删除" />
    </form>
</body>
</html>
