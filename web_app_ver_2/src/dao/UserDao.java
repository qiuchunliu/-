package dao;

import pojo.User;


public interface UserDao {

    // �����û���Ϣ
    int insert(User user);

    // ͨ���û�������ѯ�û���Ϣ
    User findUserByUname(String uname);

    // �޸��û���Ϣ
    boolean updateUser(User user);

    // �����û� id ��ɾ���û�
    boolean delet(Integer id);

}

