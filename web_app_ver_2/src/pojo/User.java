package pojo;

import java.util.Date;

public class User {
    private Integer user_id;
    private String uname;
    private String pass;
    private String email;
    private String gender;
    private Date register_time;
    private Date last_logintime;

    public User() {
    }

    public User(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
    }
    public User(Integer id, String uname, String pass) {
        this.user_id = id;
        this.uname = uname;
        this.pass = pass;
    }

    public Integer getUid() {
        return user_id;
    }

    public void setUid(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", uname='" + uname + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
