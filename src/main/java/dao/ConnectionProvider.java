package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    Connection connection;

public Connection getConnection(){
    try {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/green_panda_beans?serverTimezone=UTC",
                "root", "mysql");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
}
}
