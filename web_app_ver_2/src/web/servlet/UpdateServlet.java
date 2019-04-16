package web.servlet;

import factory.Factory;
import pojo.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 更新用户信息
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(id, username, password);
        boolean isSuccess = userService.update(user);

        if(isSuccess) {  // 如果修改成功
            // 重定向
            response.sendRedirect("/web_app/updateDone.jsp");
        }else {
            //请求转发
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
