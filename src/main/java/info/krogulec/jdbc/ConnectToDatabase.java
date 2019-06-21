package info.krogulec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {

    public static void main(String[] args) {

        //w URL musi być jdbc::nazwa_bazy:dalsza część jest opcjonalna. Ważna, że są to pojedyncze dwukropki w każdej sytuacji
        final String url = "jdbc:mysql://localhost:3306/zoo?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        insertValue(url, "foka", 12, 10.00);


    }

    private static void insertValue(String url, String animalName, Integer animalCount, Double speed) {

        //DriverManager jest częścią drivera dla danej bazy danych
        //Driver musi implementować interfejsy - Statement, Connection, ResultSet - Ważne, że implementacja DriverManager jest częścią JDK!
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             Statement statement = conn.createStatement()) {

            //widać implementację
            System.out.println(conn);
            System.out.println(statement);

            //update zwraca liczbę zmienionych wierszy
            int i = statement.executeUpdate("INSERT INTO animals (name, count, avarage_speed) VALUES (\'" + animalName + "\', " + animalCount + ", " + speed + ")");
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
