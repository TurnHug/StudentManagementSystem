package output;

import student.jdbcConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author TurnHug
 * @date 2022/9/19 12:01
 */
public class getData {
    public static Object[][] all() throws SQLException {
        String sql = "select * from student;";
        Connection con = jdbcConnect.getConnection();

        assert con != null;
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet st = pst.executeQuery();

        int count = 0;
        while (st.next()) {
            count++;
        }
        ResultSet rs = pst.executeQuery();

        Object[][] info = new Object[count][6];

        count = 0;
        while (rs.next()) {
            info[count][0] = rs.getInt("id");
            info[count][1] = rs.getString("name");
            info[count][2] = rs.getInt("Chinese");
            info[count][3] = rs.getString("Math");
            info[count][4] = rs.getString("English");
            info[count][5] = rs.getString("sum");
            count++;
        }

        st.close();
        pst.close();
        con.close();

        return info;
    }

    public static Object[][] sort() throws SQLException {
        String sql = "select * from student order by sum desc;;";
        Connection con = jdbcConnect.getConnection();

        assert con != null;
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet st = pst.executeQuery();

        int count = 0;
        while (st.next()) {
            count++;
        }
        ResultSet rs = pst.executeQuery();

        Object[][] info = new Object[count][6];

        count = 0;
        while (rs.next()) {
            info[count][0] = rs.getInt("id");
            info[count][1] = rs.getString("name");
            info[count][2] = rs.getInt("Chinese");
            info[count][3] = rs.getString("Math");
            info[count][4] = rs.getString("English");
            info[count][5] = rs.getString("sum");
            count++;
        }

        st.close();
        pst.close();
        con.close();

        return info;
    }
}