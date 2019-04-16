package web.servlet;

import factory.Factory;
import pojo.Book;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindBookServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> blist = userService.listBook();
        /*
         * 如果集合不为空，则说明查到了书籍
         * 如果集合为空，则说明没查到书籍，跳去错误页面并提示
         */
        if(blist.size() != 0) {
            request.setAttribute("blist", blist);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }else {
            request.setAttribute("error", "没有书籍信息");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
