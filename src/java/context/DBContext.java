
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBContext {
    /**Store server name. */
    private final String serverName = "localhost";
    /**Store database name. */
    private final String dbName = "OnlineQuiz";
    /**port number. */
    private final String portNumber = "1433";
    /**Store user. */
    private final String user = "sa";
    /**Store password. */
    private final String password = "123456";

    /**
     * getConnection.<br>
     * 
     * @return the connection
     * @throws Exception 
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * closeConection.<br>
     * 
     * @param conn
     * @param pstmt
     * @param rs
     * @throws SQLException 
     */
    public void closeConection(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {

        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }

}
