
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQLite {

    public static void main(String[] args) {
        ConnectionSQLite connectionSQLite = new ConnectionSQLite();
        connectionSQLite.initConnection();
    }

    Connection connection;

    public void initConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:sqlite_database_2022.db");
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

}
