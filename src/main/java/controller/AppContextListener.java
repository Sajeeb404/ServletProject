package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialization code if needed
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Unregister JDBC drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Deregistered JDBC driver: " + driver);
            } catch (SQLException e) {
                System.err.println("Error deregistering JDBC driver: " + e.getMessage());
            }
        }

        // Stop the abandoned connection cleanup thread
        try {
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }

}
