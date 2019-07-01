import java.sql.*;
import com.mysql.jdbc.Driver;

public class Connect {
    // Make private connection variable
    private static Connection connect;
    
    // Function for get the connection of database
    public static Connection GetConnection() throws SQLException{
        if (connect == null) {
            Driver driver = new Driver();
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_final?zeroDateTimeBehavior=convertToNull", "root", "");
        }
        return connect;
    }
}