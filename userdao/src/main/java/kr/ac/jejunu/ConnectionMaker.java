package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-01.
 */
public interface ConnectionMaker {

    Connection getConnection() throws ClassNotFoundException, SQLException;
}
