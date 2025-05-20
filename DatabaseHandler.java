
package university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DatabaseHandler {
    protected Connection conn;

    public DatabaseHandler(Connection conn) {
        this.conn = conn;
    }

    protected void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
}
