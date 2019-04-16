package dao.impl;

import dao.BookDao;
import pojo.Book;
import utils.JdbcUtils;

import java.util.List;

public class BookDaoImpl implements BookDao {

    public BookDaoImpl() { }

    /**
     * 获取所有的书籍信息
     * @return 返回一个书籍集合
     */
    @Override
    public List<Book> getBookList() {
        String sql = "select * from book_info ORDER BY creation_time";
        List<Book> books = JdbcUtils.executeDQL(sql, Book.class);
        return books;
    }

    @Override
    public List<Book> getBookByCondition(Integer book_type, String bookname, Integer is_borrow) {
        String sql = "select * from book_info where book_type = ? and book_name like ? and is_borrow = ? ORDER BY creation_time";
        List<Book> books = JdbcUtils.executeDQL(sql, Book.class, book_type, "%" + bookname + "%", is_borrow);

        return books;
    }

    @Override
    public boolean updateBookBorrow(Integer book_id) {
        String sql = "UPDATE book_info set is_borrow = 1 WHERE book_id = ?";
        int i = JdbcUtils.executeDML(sql, book_id);
        return i != 0;
    }
}
