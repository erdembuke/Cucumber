package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_FirstLastGetRowgetType extends JDBCParent {

    @Test
    public void Test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city from city");

        rs.last(); // son satira gider
        rs.first(); // ilk satira gider

        rs.last();
        int kacinciSatir = rs.getRow(); // kacinca satirda oldugumu veriyor
        System.out.println("kacincisatirdayim = " + kacinciSatir);
    }
}
