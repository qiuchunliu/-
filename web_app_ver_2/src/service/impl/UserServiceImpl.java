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
     * 用户操作
     * 书籍操作
     */
    private UserDao userDao = Factory.getUserDaoImpl();
    private BookDao bookDao = Factory.getBookDaoImpl();

    public UserServiceImpl() { }

    /**
     * 用户注册
     */
    @Override
    public boolean regist(User user) {
        int row = userDao.insert(user);
        return row != 0;
    }

    /**
     * 用户登录
     * @param user  登录的用户对象
     * @return  返回登录是否成功
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
     * 更新用户信息
     * @param user  待更新用户
     * @return  返回是否更新成功
     */
    @Override
    public boolean update(User user) {
        if(user != null) return userDao.updateUser(user);
        return false;
    }

    /**
     * 根据id来删除用户
     * @param id 待删除的用户
     * @return 返回是否删除成功
     */
    @Override
    public boolean delet(Integer id) {
        return userDao.delet(id);
    }

    /**
     * 查询所有书籍信息
     * @return 返回书籍集合
     */
    @Override
    public List<Book> listBook() {
        List<Book> bookList = bookDao.getBookList();
        return bookList;
    }

    /**
     * 按条件查询书籍信息
     * @param book_type  书籍的分类
     * @param bookname  书籍名称关键字
     * @param is_borrow  书籍的借阅状态
     * @return 返回查询到的集合
     */
    @Override
    public List<Book> findBookByCondition(Integer book_type, String bookname, Integer is_borrow) {
        List<Book> books = bookDao.getBookByCondition(book_type, bookname, is_borrow);
        return books;
    }

    /**
     * 更新书籍的借阅状态
     * @param book_id 待更新书籍的 id
     * @return 返回是否更新成功
     */
    @Override
    public boolean updateBookBorrow(Integer book_id) {
        return bookDao.updateBookBorrow(book_id);
    }
}