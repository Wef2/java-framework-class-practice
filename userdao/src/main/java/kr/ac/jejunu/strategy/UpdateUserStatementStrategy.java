package kr.ac.jejunu.strategy;

import kr.ac.jejunu.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-08.
 */
public class UpdateUserStatementStrategy implements StatementStrategy {

    private User user;

    public UpdateUserStatementStrategy(User user){
        this.user = user;
    }

    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        String sql = "UPDATE user SET name = ?, password = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setLong(3, user.getId());
        return preparedStatement;
    }
}
