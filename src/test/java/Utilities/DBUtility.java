package Utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {

    public static Connection connection;
    public static Statement statement;

    public static ArrayList<ArrayList<String>> queryResult(String query){
        DBConnectionOpen();
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
        DBConnectionClose();
        return list;
    }

    public static void  DBConnectionOpen(){
        String hostName = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(hostName, username, password);
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void DBConnectionClose(){
        try {
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
