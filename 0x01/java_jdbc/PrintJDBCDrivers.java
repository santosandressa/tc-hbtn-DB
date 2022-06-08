import org.sqlite.JDBC;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) throws SQLException {
        Driver driver = new JDBC();

        DriverManager.registerDriver(driver);

        // Get a list of all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        // Print the drivers and versions
        while (drivers.hasMoreElements()) {
            Driver d = drivers.nextElement();
            System.out.println(d.getClass().getName() + " " + d.getMajorVersion() + "." + d.getMinorVersion());
        }
    }
}
