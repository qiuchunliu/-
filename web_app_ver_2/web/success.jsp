<%@ page import="pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Book" %>

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
    <title>Title</title>
</head>
<body>
    <h1>
        图书借阅系统
    </h1>
    <h3>
        尊敬的 <% out.write(((User)(session.getAttribute("user"))).getUname());    %>， 您已登录成功！
    </h3>
    <a href="index.jsp">-->退出<--</a>
    <br />
    <!-- ↓ 条件查询模块 ↓ -->
    <form action="findBookByConditionServlet" method="get">
        图书分类：
        <select name="book_type">
            <option value="1">小说</option>
            <option value="2">文学</option>
            <option value="3">传记</option>
            <option value="4">艺术</option>
            <option value="5">少儿</option>
            <option value="6">经济</option>
            <option value="7">管理</option>
            <option value="8">科技</option>
        </select>
        图书名称：
        <input type="text" name="bookname">
        是否借阅：
        <select name="is_borrow">
            <option value=1>已借阅</option>
            <option value=2>未借阅</option>
        </select>
        <input type="submit" value="查询" />
        <br />
    </form>
    <!-- ↑ 条件查询模块 ↑ -->
    <br>
    <br />

    <table border=1>
        <tr bgcolor="#186a8b">
            <th>编号</th>
            <th>分类</th>
            <th>名称</th>
            <th>作者</th>
            <th>出版社</th>
            <th>是否借阅</th>

        </tr>
        <% List<Book> list = (List<Book>) request.getAttribute("blist"); %> <!-- 获取到用户集合-->
        <%if(list.size() != 0) {%>
        <%for(int i = 0;i<list.size();i++) {   %>
        <tr bgcolor="<%= i%2 != 0 ? "#186a8b" : "" %>">

            <td><%out.write(String.valueOf(list.get(i).getBook_code()));   %></td>
            <td><%out.write(list.get(i).getBook_type());   %></td>
            <td><%out.write(list.get(i).getBook_name());   %></td>
            <td><%out.write(list.get(i).getBook_author());   %></td>
            <td><%out.write(list.get(i).getPublish_press());   %></td>
            <!--是否借阅-->
            <td align="center">
                <%
                    if(list.get(i).getIs_borrow() == 1)
                        out.write("已借阅");
                    else { %>
                <a href="updateBookServlet?book_id=<%=list.get(i).getBook_id()%>">申请借阅</a>
                    <%}%>
            </td>
        </tr>
        <% }}else {%>
        <tr><td  colspan="6" align="center">对不起没有查到任何结果</td></tr>
        <%}%>
    </table>
</body>
</html>
