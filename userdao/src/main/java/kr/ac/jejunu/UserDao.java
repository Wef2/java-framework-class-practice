package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by Kim on 2016-03-25.
 */
public class UserDao {

    public User get(Long id) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root123");
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery(sql);
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong(0));
        user.setName(resultSet.getString(1));
        user.setPassword(resultSet.getString(2));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }
}
