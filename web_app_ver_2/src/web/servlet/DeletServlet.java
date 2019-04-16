package web.servlet;

import factory.Factory;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletServlet extends HttpServlet {

    private UserService userService = Factory.getUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id_to_delet"));
        boolean isDelet = userService.delet(id);
        if(isDelet) response.sendRedirect("/web_app/deletDone.jsp");
        else request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
}
