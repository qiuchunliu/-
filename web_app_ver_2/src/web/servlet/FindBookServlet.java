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
         * ������ϲ�Ϊ�գ���˵���鵽���鼮
         * �������Ϊ�գ���˵��û�鵽�鼮����ȥ����ҳ�沢��ʾ
         */
        if(blist.size() != 0) {
            request.setAttribute("blist", blist);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }else {
            request.setAttribute("error", "û���鼮��Ϣ");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
