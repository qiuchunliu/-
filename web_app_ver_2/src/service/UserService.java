package service;

import pojo.Book;
import pojo.User;

import java.util.List;

public interface UserService {
    boolean regist(User user);
    boolean login(User user);
    boolean update(User user);
    boolean delet(Integer id);

    List<Book> listBook();

    List<Book> findBookByCondition(Integer book_type, String bookname, Integer is_borrow);

    boolean updateBookBorrow(Integer book_id);
}
