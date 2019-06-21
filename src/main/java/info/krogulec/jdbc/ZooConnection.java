package info.krogulec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ZooConnection {

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/zoo?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private ZooConnection(){}

    public static synchronized Connection getInstance(){
        try {
            if (connection == null || connection.isClosed()){
                createNewConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

    private static synchronized void createNewConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
    }
}
