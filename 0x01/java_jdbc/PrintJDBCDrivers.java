import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();){
            Driver driver = e.nextElement();

            String className = driver.getClass().getName();
            int majorVersion = driver.getMajorVersion();
            int minorVersion = driver.getMinorVersion();

            System.out.printf("%s %d - %d\n", className, minorVersion, minorVersion);

        }
    }
} 
