package dao;

import pojo.User;


public interface UserDao {

    // 增加用户信息
    int insert(User user);

    // 通过用户名来查询用户信息
    User findUserByUname(String uname);

    // 修改用户信息
    boolean updateUser(User user);

    // 根据用户 id 来删除用户
    boolean delet(Integer id);

}

