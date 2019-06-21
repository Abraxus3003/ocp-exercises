package info.krogulec.jdbc;

import java.sql.*;

public class JdbcDates {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root")){
            Statement createLion = connection.createStatement();

            //stworzenie nowego zwierzaka
            int i = createLion.executeUpdate("INSERT INTO animals VALUES ('lion',14,22.1, TIMESTAMP('2017-07-23',  '13:10:11'), '2012-01-14')");
            System.out.println(i);

            //wyciagniecie danych i odczytanie
            Statement queryForLion = connection.createStatement();
            ResultSet lion = queryForLion.executeQuery("SELECT * FROM animals WHERE name = 'lion'");

            if (lion.next()){

                Timestamp createdDate = lion.getTimestamp("createdDate");
                Date vaccineDate = lion.getDate("vaccineDate");
                Date createdDare = lion.getDate("createdDate");

                System.out.println(lion.getString("name"));
                System.out.println(lion.getTimestamp("createdDate"));
                System.out.println(lion.getDate("vaccineDate"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
