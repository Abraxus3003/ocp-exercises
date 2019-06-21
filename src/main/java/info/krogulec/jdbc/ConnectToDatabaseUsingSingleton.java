package info.krogulec.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabaseUsingSingleton {

    public static void main(String[] args) throws SQLException {

        Connection connection = ZooConnection.getInstance();

        Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM animals");

        //to string zwraca hashCode obiektu
        System.out.println(resultSet);

        while (resultSet.next()){
            int row = resultSet.getRow();
            String name = resultSet.getString("name");
            System.out.println("Row: " + row + " " + name);
        }
    }
}
