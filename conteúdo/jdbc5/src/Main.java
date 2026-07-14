import db.DB;
import db.DBIntegrityException;
import db.DbException;

import java.sql.*;

void main() {
    Connection conn = null;
    PreparedStatement st = null;

    try{
        conn = DB.getConnection();
        st = conn.prepareStatement(
        """
            DELETE FROM department
            WHERE
            Id = ?
            """
        );

        st.setInt(1, 6);

        int rowsAffected = st.executeUpdate();

        System.out.println("Done! Rows affected: " + rowsAffected);

    } catch (SQLException e){
//        throw new DbException(e.getMessage());
        throw new DBIntegrityException(e.getMessage());
    } finally {

        DB.closeStatement(st);
        DB.closeConnection();
    }

}
