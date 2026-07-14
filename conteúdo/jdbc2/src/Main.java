import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

void main() {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        conn = DB.getConnection();
        st = conn.createStatement();
        rs = st.executeQuery("Select * from department");

        while (rs.next()){
            System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        DB.closeResultSet(rs);
        DB.closeStatement(st);
        DB.closeConnection();
    }

}
