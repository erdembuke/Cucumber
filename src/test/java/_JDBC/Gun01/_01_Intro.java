package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void Test1() throws SQLException {
        String hostName = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password="'\"-LhCB'.%k[4S]z";

        // connection aciliyor , fileInputStream
        Connection connection = DriverManager.getConnection(hostName,username,password);

        // sql lerin yazilacagi sayfa
        Statement statement = connection.createStatement(); // sorgulari calistirmak icin sorgu gonderme ortami

        // sorguyu yazdim ve calistirdim
        ResultSet resultSet = statement.executeQuery("select * from customer"); // sorgu calisti , sonuclari nerde? resultSet'de

        // ilk satirimi istiyorsun , son satiri mi , 5. satiri mi
        resultSet.next(); // siradaki diyince 1. satira gitti

        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        System.out.println("1. satirin musteri adi ve soyadi = " + firstName + " " + lastName);

        resultSet.next(); // 2. satira

        String firstName2 = resultSet.getString("first_name");
        String lastName2 = resultSet.getString("last_name");
        System.out.println("2. satirin musteri adi ve soyadi = " + firstName2 + " " + lastName2);

        connection.close();

    }
}
