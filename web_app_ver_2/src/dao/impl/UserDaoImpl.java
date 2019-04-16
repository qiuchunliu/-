package dao.impl;

import dao.UserDao;
import pojo.Book;
import pojo.User;
import utils.JdbcUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() { }

    @Override
    public int insert(User user) {
        if(user == null) return 0;
        String sql = "insert into users(user_code, password, email, gender, register_time, last_logintime) values(?,?,?,?,?,?)";
        return JdbcUtils.executeDML(sql, user.getUname(), user.getPass(), user.getUname()+"@qq.com", "��", "19990909", "19990909");
    }

    @Override
    public User findUserByUname(String uname) {
        String sql = "select * from users where user_code=?";
        List<User> users = JdbcUtils.executeDQL(sql, User.class, uname);
        return users.size() == 0 ?  null : users.get(0);
    }

    /**
     * �޸��û���Ϣ
     * @param user ���޸��û�
     * @return  ����һ���Ƿ��޸ĳɹ�
     */
    @Override
    public boolean updateUser(User user) {
        if(user == null) return false;
        String sql = "UPDATE users SET user_code = ?, password = ? WHERE user_id=?";
        int i = JdbcUtils.executeDML(sql, user.getUname(), user.getPass(), user.getUid());
        return i != 0;  // ����޸���һ�У��� i ��= 0����� i == 0�� ˵���޸�ʧ��
    }

    @Override
    public boolean delet(Integer id) {
        String sql = "delete from users where user_id = ?";
        int i = JdbcUtils.executeDML(sql, id);
        return i != 0;
    }


}
