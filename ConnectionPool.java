package net.integrio.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private static String url = "jdbc:mysql://localhost:3306/usersdb";
    private static String username = "root";
    private static String password = "";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);


    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null)
        connection.close();
    }
}
