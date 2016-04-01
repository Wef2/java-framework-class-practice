package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-01.
 */
public class SimpleConnectionMaker implements ConnectionMaker {

    public SimpleConnectionMaker(){

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root123");
    }
}
