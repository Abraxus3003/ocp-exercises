package info.krogulec.jdbc;

import java.sql.*;

public class QueryDatabase {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root")){
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("UPDATE animals SET name = 'zebra'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animals");
            System.out.println(i);

            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

            Statement executeTest = connection.createStatement();

            boolean isResultSet = executeTest.execute("SELECT * FROM animals");

            if (isResultSet){
                ResultSet resultSet1 = executeTest.getResultSet();

                while (resultSet1.next()){
                    System.out.println(resultSet1.getInt("count"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
