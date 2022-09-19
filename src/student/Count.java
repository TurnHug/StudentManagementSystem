package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author TurnHug
 * @date 2022/9/19 12:12
 */
public class Count {
    Connection con = null;
    public int cout() throws SQLException {
        String sql = "select count(id) from student;";
        con = jdbcConnect.getConnection();

        assert con != null;
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet st = pst.executeQuery();
        int c = 0;
        if (st.next()) {
            c = st.getInt(1);
        }
        st.close();
        pst.close();
        con.close();
        return c;
    }
}
