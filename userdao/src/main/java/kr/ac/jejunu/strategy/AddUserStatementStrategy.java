package kr.ac.jejunu.strategy;

import kr.ac.jejunu.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-08.
 */
public class AddUserStatementStrategy implements StatementStrategy {
    private User user;

    public AddUserStatementStrategy(User user) {
        this.user = user;
    }

    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        String sql = "INSERT INTO user (name, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement;
    }
}
