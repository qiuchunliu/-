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
     * �����鼮�Ľ���״̬
     * ���������ĺ��Ϊ�ѽ���
     * ͨ�� book_id ������
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer book_id = Integer.valueOf(request.getParameter("book_id"));
        boolean isSuccess = userService.updateBookBorrow(book_id);

        if(isSuccess) {  // ����޸ĳɹ�
            // �ض���
            response.sendRedirect("/web_app/findBookServlet");
        }else {
            //����ת��
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
