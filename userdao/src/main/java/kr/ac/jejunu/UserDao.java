package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by Kim on 2016-03-25.
 */
public class UserDao {

    private final ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        String sql = "INSERT INTO user (name, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();

        Long id = getLastInsertId(connection);
        preparedStatement.close();
        connection.close();

        return id;
    }

    private Long getLastInsertId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT last_insert_id()");

        ResultSet resultSet = preparedStatement2.executeQuery();
        resultSet.next();
        Long id = resultSet.getLong(1);

        resultSet.close();
        preparedStatement2.close();
        return id;
    }
}
