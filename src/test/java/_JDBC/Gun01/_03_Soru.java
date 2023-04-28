package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_Soru extends JDBCParent {

    // city tablosundaki tum kayitlardaki isimleri next ile yazdiriniz

    @Test
    public void Test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");
        int rowCount = 0;

        while(rs.next()){
            System.out.println(rs.getString("city"));
            rowCount++;
        }
        System.out.println("satir sayisi " + rowCount);
    }

    // TODO : city tablosundaki tum satirlardaki sehir isimlerini absolute ile yazdirin
    // TODO : city tablosundaki tum satirlardaki sehir isimlerini relative ile yazdirin
}
