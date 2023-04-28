package _JDBC.Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_NextPrevAbsRel extends JDBCParent {

    @Test
    public void textNextPrev() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next(); // ilk satir
        System.out.println(rs.getString(2)); // english

        rs.next();
        System.out.println(rs.getString(2)); // italian

        rs.next();
        System.out.println(rs.getString(2)); // japanese

        rs.previous();
        System.out.println(rs.getString(2)); // italian
    }

    @Test
    public void AbsoluteRelative() throws SQLException {
      ResultSet rs = statement.executeQuery("select * from film");

      // rs.next() : sonraki satir
      // rs.previous : onceki satir
      // rs.absolute(10) : baştan itibaren 10. satira gider
      // rs.relative(10) : bulundugu yerden 10. satira gider.
      // rs.absolute(-10); : (eksi) sondan demektir sondan 10. satir
        // rs.relative(-5) : (eksi) bulundugu yerden 5 satir geri.

        rs.absolute(10); // 10. satira git
        System.out.println("10. satir title -> " + rs.getString("title"));

        rs.relative(5); // 15. satira gider. en son bulundugu yerden 5 satir gider.
        System.out.println(rs.getString("title"));

        rs.absolute(-10); // sondan 10. satira git
        System.out.println(rs.getString("title"));




    }
}
