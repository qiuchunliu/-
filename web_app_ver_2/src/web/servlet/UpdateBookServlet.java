package web.servlet;

import factory.Factory;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateBookServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 更新书籍的借阅状态
     * 点击申请借阅后变为已借阅
     * 通过 book_id 来操作
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer book_id = Integer.valueOf(request.getParameter("book_id"));
        boolean isSuccess = userService.updateBookBorrow(book_id);

        if(isSuccess) {  // 如果修改成功
            // 重定向
            response.sendRedirect("/web_app/findBookServlet");
        }else {
            //请求转发
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
