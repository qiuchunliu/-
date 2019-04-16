package dao;

import pojo.Book;

import java.util.List;

public interface BookDao {

    /**
     * 查询全部的图书信息
     * @return 返回书的列表
     */
    List<Book> getBookList();

//    Book findBook();

    /**
     * 根据所给的条件查询
     * @param book_type  书的分类
     * @param bookname  书名
     * @param is_borrow  是否借阅
     * @return  返回一个查到的书的集合
     */
    List<Book> getBookByCondition(Integer book_type, String bookname, Integer is_borrow);

    /**
     * 更新书籍的借阅状态
     * @param book_id 根据所给的id
     * @return 返回是否跟新成功
     */
    boolean updateBookBorrow(Integer book_id);
}
