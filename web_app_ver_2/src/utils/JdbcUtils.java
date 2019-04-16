package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import pojo.User;

import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  封装了JDBC代码的工具类
 */
public class JdbcUtils {

    public JdbcUtils() {
    }

    private static Connection connection;
    private static ComboPooledDataSource dataSource;

    static {
        //1. 加载驱动
        try {

            // 创建一个连接池
            dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=GMT");
            dataSource.setUser("root");
            dataSource.setPassword("1234");
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            // 通过用户名和密码还有url去连接mysql的服务器,得到连接对象
            connection = dataSource.getConnection();
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    /**
     * 封装dml语句
     */
    public static int executeDML(String sql, Object...args) {
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            if(connection.isClosed()) connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给参数赋值
            for(int i = 0;i < args.length;i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection, preparedStatement, null);
        }
        return row;
    }

    public static <T> List<T> executeDQL(String sql, Class<T> clazz, Object...args) {
        List<T> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 如果 connection 是关闭状态，则重新获取连接
            // 如果不是关闭状态，则继续执行
            if(connection.isClosed()) connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 给参数赋值
            for(int i = 0;i < args.length;i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            resultSet = preparedStatement.executeQuery(); // 执行sql语句
            // 获取你要查询的表的列的列表（对象模型的属性列表）
            Field[] fields = clazz.getDeclaredFields();
            while(resultSet.next()) {
                // 创建一个对象
                T t = clazz.newInstance();
                // 遍历
                for(int i = 0;i < fields.length;i++) {
                    // 获取到属性对象
                    Field field = fields[i];
                    // 属性对象对应的值
                    Object object = resultSet.getObject(i + 1); // 这个类中的一个属性
                    // 赋值
                    field.setAccessible(true);  // 如果是 私有属性，则设置私有属性可获取
                    field.set(t, object);
                }
                // 将对象添加到集合中
                list.add(t);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            close(null, preparedStatement, resultSet);
        }
        return list;
    }

    /**
     * 释放资源
     */
    private static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null)  connection.close(); // 将连接归还给数据库连接池
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取 User 类的集合
     * User 类专用
     */
    public static List<User> getUser() {
        String sql = "select * from users";
        return executeDQL(sql, User.class);
    }
}
