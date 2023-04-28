package _JDBC.Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class _01_GetAllRowColumn extends JDBCParent {

    @Test
    public void test0() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData(); // kolon sayisi , isimleri , tipleri

        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("name = " + rsmd.getColumnName(i) + " / ");
            System.out.println("type = " + rsmd.getColumnTypeName(i));
        }
    }
    @Test
    public void  test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language"); // burasi dinamik , her sey calisir

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("name = " + rsmd.getColumnName(i) + " / ");
            System.out.println("type = " + rsmd.getColumnTypeName(i));
        }

        while (rs.next()){
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void soruTest() {
        // bir metoda sorguyu gonderiniz , metod size sorgunun datasini
        // bir ArrayList olarak dondursun
        String sql = "select * from language";
        System.out.println(queryResult(sql));
    }

    public ArrayList<ArrayList<String>> queryResult(String query){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                list.add(row);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return list;
    }
}
