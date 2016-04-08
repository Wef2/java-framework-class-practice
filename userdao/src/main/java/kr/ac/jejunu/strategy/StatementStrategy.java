package kr.ac.jejunu.strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-08.
 */
public interface StatementStrategy {

    PreparedStatement makeStatement(Connection connection) throws SQLException;
}
