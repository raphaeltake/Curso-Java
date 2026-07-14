import db.DB;
import db.DbException;

import java.sql.*;

void main() {
    Connection conn = null;
    PreparedStatement st = null;

    try{
        conn = DB.getConnection();
        st = conn.prepareStatement(
                "UPDATE seller " +
                        "set BaseSalary = BaseSalary + ? " +
                        "WHERE " +
                        "DepartmentId = ?"
        );

        st.setDouble(1, 200.00);
        st.setInt(2, 2);

        int rowsAffected = st.executeUpdate();

        System.out.println("Done! Rows affected: " + rowsAffected);

    } catch (SQLException e){
        throw new DbException(e.getMessage());
    } finally {
        DB.closeStatement(st);
        DB.closeConnection();
    }

}
