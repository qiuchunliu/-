package web.servlet;

import factory.Factory;
import pojo.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 如果用户名字符串长度不够
        // 则报错
        if(username.length() < 7) {
            request.setAttribute("error", "用户名长度不够，应为 7 位");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        if(password.length() < 6) {
            request.setAttribute("error", "密码长度不够，应为 6 位");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        User user = new User(username, password);
        boolean isLogin = userService.login(user);
        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/web_app/findBookServlet");
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
