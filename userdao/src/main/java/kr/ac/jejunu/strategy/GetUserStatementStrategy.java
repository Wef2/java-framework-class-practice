package kr.ac.jejunu.strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-08.
 */
public class GetUserStatementStrategy implements StatementStrategy {

    private Long id;

    public GetUserStatementStrategy(Long id) {
        this.id = id;
    }

    public PreparedStatement makeStatement(Connection connection) throws SQLException{
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
