import org.sqlite.JDBC;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Logger;

public class PrintJDBCDrivers {
    public static void main(String[] args) throws SQLException {
        Logger logger = Logger.getLogger(PrintJDBCDrivers.class.getName());
        Driver driver = new JDBC();

        DriverManager.registerDriver(driver);

        // Get a list of all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        // Print the drivers and versions
        while (drivers.hasMoreElements()) {
            Driver d = drivers.nextElement();
            logger.info(d.getClass().getName() + " " + d.getMajorVersion() + "." + d.getMinorVersion());
        }
    }
}
