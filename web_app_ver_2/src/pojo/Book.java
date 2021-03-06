package pojo;

import java.util.Date;

public class Book {

    private Integer book_id;
    private String book_code;
    private String book_name;
    private Integer book_type;
    private String book_author;
    private String publish_press;
    private Date publish_date;
    private Integer is_borrow;
    private String createdBy;
    private Date creation_time;
    private Date last_updatetime;

    public Book() {
    }

    public Book(Integer book_id, String book_code, String book_name, Integer book_type, String book_author, String publish_press, Date publish_date, Integer is_borrow, String createdBy, Date creation_time, Date last_updatetime) {
        this.book_id = book_id;
        this.book_code = book_code;
        this.book_name = book_name;
        this.book_type = book_type;
        this.book_author = book_author;
        this.publish_press = publish_press;
        this.publish_date = publish_date;
        this.is_borrow = is_borrow;
        this.createdBy = createdBy;
        this.creation_time = creation_time;
        this.last_updatetime = last_updatetime;
    }



    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_type() {
        String type = null;
        switch (this.book_type) {
            case 1:
                type = "小说";
                break;
            case 2:
                type = "文学";
                break;
            case 8:
                type = "科技";
                break;
        }
        return type;
    }

    public void setBook_type(Integer book_type) {
        this.book_type = book_type;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getPublish_press() {
        return publish_press;
    }

    public void setPublish_press(String publish_press) {
        this.publish_press = publish_press;
    }

    public Date getPublist_date() {
        return publish_date;
    }

    public void setPublist_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getIs_borrow() {
        return is_borrow;
    }

    public void setIs_borrow(Integer is_borrow) {
        this.is_borrow = is_borrow;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public Date getLast_updatetime() {
        return last_updatetime;
    }

    public void setLast_updatetime(Date last_updatetime) {
        this.last_updatetime = last_updatetime;
    }
}
