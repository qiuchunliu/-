package dao;

import pojo.Book;

import java.util.List;

public interface BookDao {

    /**
     * ��ѯȫ����ͼ����Ϣ
     * @return ��������б�
     */
    List<Book> getBookList();

//    Book findBook();

    /**
     * ����������������ѯ
     * @param book_type  ��ķ���
     * @param bookname  ����
     * @param is_borrow  �Ƿ����
     * @return  ����һ���鵽����ļ���
     */
    List<Book> getBookByCondition(Integer book_type, String bookname, Integer is_borrow);

    /**
     * �����鼮�Ľ���״̬
     * @param book_id ����������id
     * @return �����Ƿ���³ɹ�
     */
    boolean updateBookBorrow(Integer book_id);
}
