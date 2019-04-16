package web.servlet;

import factory.Factory;
import pojo.Book;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindBookByConditionServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookname;

        // Integer.valueOf(),返回一个 Integer 类型的对象
        // Integer.parseInt(), 返回一个 int 类型的数据
        Integer book_type = Integer.valueOf(request.getParameter("book_type"));
        bookname = request.getParameter("bookname");
        Integer is_borrow = Integer.valueOf(request.getParameter("is_borrow"));
        List<Book> books = userService.findBookByCondition(book_type, bookname, is_borrow);
        request.setAttribute("blist", books);
        request.getRequestDispatcher("/success.jsp").forward(request,response);
    }
}
