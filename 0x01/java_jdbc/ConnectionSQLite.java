import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
public class ConnectionSQLite {
    public static void main(String[] args) throws SQLException {
        ConnectionSQLite connectionSQLite = new ConnectionSQLite();
        connectionSQLite.initConnection();
    }

    Connection connection;
    
    Logger logger = Logger.getLogger(ConnectionSQLite.class.getName());
    public void initConnection() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:sqlite_database_2022.db");
            logger.info("Connection to SQLite has been established.");
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Connection to SQLite has not been established.", e);
        }
    }
}
