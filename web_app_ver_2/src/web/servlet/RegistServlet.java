package web.servlet;

import factory.Factory;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.length() < 7) {
            request.setAttribute("error", "�û������Ȳ�����ӦΪ 7 λ");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        }
        if(password.length() < 6) {
            request.setAttribute("error", "���볤�Ȳ�����ӦΪ 6 λ");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        }

        User user = new User(username, password);
        boolean isSuccess = userService.regist(user);

        if(isSuccess) {
            // �ض���
            response.sendRedirect("/web_app/index.jsp");
        }else {
            //����ת��
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
