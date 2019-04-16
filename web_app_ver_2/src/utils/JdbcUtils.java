package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import pojo.User;

import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  ��װ��JDBC����Ĺ�����
 */
public class JdbcUtils {

    public JdbcUtils() {
    }

    private static Connection connection;
    private static ComboPooledDataSource dataSource;

    static {
        //1. ��������
        try {

            // ����һ�����ӳ�
            dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=GMT");
            dataSource.setUser("root");
            dataSource.setPassword("1234");
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            // ͨ���û��������뻹��urlȥ����mysql�ķ�����,�õ����Ӷ���
            connection = dataSource.getConnection();
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��װdml���
     */
    public static int executeDML(String sql, Object...args) {
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            if(connection.isClosed()) connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //��������ֵ
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
            // ��� connection �ǹر�״̬�������»�ȡ����
            // ������ǹر�״̬�������ִ��
            if(connection.isClosed()) connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // ��������ֵ
            for(int i = 0;i < args.length;i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            resultSet = preparedStatement.executeQuery(); // ִ��sql���
            // ��ȡ��Ҫ��ѯ�ı���е��б�����ģ�͵������б�
            Field[] fields = clazz.getDeclaredFields();
            while(resultSet.next()) {
                // ����һ������
                T t = clazz.newInstance();
                // ����
                for(int i = 0;i < fields.length;i++) {
                    // ��ȡ�����Զ���
                    Field field = fields[i];
                    // ���Զ����Ӧ��ֵ
                    Object object = resultSet.getObject(i + 1); // ������е�һ������
                    // ��ֵ
                    field.setAccessible(true);  // ����� ˽�����ԣ�������˽�����Կɻ�ȡ
                    field.set(t, object);
                }
                // ��������ӵ�������
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
     * �ͷ���Դ
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
            if(connection != null)  connection.close(); // �����ӹ黹�����ݿ����ӳ�
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡ User ��ļ���
     * User ��ר��
     */
    public static List<User> getUser() {
        String sql = "select * from users";
        return executeDQL(sql, User.class);
    }
}
