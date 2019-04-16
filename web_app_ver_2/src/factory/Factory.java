package factory;

import dao.impl.BookDaoImpl;
import dao.impl.UserDaoImpl;
import service.impl.UserServiceImpl;

public class Factory {


    // private UserService userService = new UserServiceImpl();
    public static UserServiceImpl getUserServiceImpl() {
        Class clazz;
        String s = "service.impl.UserServiceImpl";
        try {
            clazz = Class.forName(s);
            Object o = clazz.newInstance();
            return (UserServiceImpl) o;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    // private UserDao userDao = new UserDaoImpl();
    public static UserDaoImpl getUserDaoImpl() {
        Class clazz;
        String s = "dao.impl.UserDaoImpl";
        try {
            clazz = Class.forName(s);
            Object o = clazz.newInstance();
            return (UserDaoImpl) o;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BookDaoImpl getBookDaoImpl() {
        Class clazz;
        String s = "dao.impl.BookDaoImpl";
        try {
            clazz = Class.forName(s);
            Object o = clazz.newInstance();
            return (BookDaoImpl) o;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
