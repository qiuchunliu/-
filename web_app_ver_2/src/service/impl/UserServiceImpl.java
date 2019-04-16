package service.impl;

import dao.BookDao;
import dao.UserDao;
import factory.Factory;
import pojo.Book;
import pojo.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {


    /**
     * �û�����
     * �鼮����
     */
    private UserDao userDao = Factory.getUserDaoImpl();
    private BookDao bookDao = Factory.getBookDaoImpl();

    public UserServiceImpl() { }

    /**
     * �û�ע��
     */
    @Override
    public boolean regist(User user) {
        int row = userDao.insert(user);
        return row != 0;
    }

    /**
     * �û���¼
     * @param user  ��¼���û�����
     * @return  ���ص�¼�Ƿ�ɹ�
     */
    @Override
    public boolean login(User user) {
        User u = null;
        if(user != null) u = userDao.findUserByUname(user.getUname());
        if(u != null) {
            return user.getPass().trim().equalsIgnoreCase(u.getPass());
        }
        return false;
    }

    /**
     * �����û���Ϣ
     * @param user  �������û�
     * @return  �����Ƿ���³ɹ�
     */
    @Override
    public boolean update(User user) {
        if(user != null) return userDao.updateUser(user);
        return false;
    }

    /**
     * ����id��ɾ���û�
     * @param id ��ɾ�����û�
     * @return �����Ƿ�ɾ���ɹ�
     */
    @Override
    public boolean delet(Integer id) {
        return userDao.delet(id);
    }

    /**
     * ��ѯ�����鼮��Ϣ
     * @return �����鼮����
     */
    @Override
    public List<Book> listBook() {
        List<Book> bookList = bookDao.getBookList();
        return bookList;
    }

    /**
     * ��������ѯ�鼮��Ϣ
     * @param book_type  �鼮�ķ���
     * @param bookname  �鼮���ƹؼ���
     * @param is_borrow  �鼮�Ľ���״̬
     * @return ���ز�ѯ���ļ���
     */
    @Override
    public List<Book> findBookByCondition(Integer book_type, String bookname, Integer is_borrow) {
        List<Book> books = bookDao.getBookByCondition(book_type, bookname, is_borrow);
        return books;
    }

    /**
     * �����鼮�Ľ���״̬
     * @param book_id �������鼮�� id
     * @return �����Ƿ���³ɹ�
     */
    @Override
    public boolean updateBookBorrow(Integer book_id) {
        return bookDao.updateBookBorrow(book_id);
    }
}