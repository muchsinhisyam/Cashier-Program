import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    // Function for checking the connection of database
    public static Connection setConnection() {
        // Make variable db_name and set the value
        String db_name = "jdbc:mysql://localhost:3306/db_final";
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(db_name,"root","");
            System.out.println("Connection Success!");
        // Exception or error handling
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failed!");
        // Exception or error handling
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failed!");
        }
        return connect;
     }

    // Function for execute SQL syntax
    public static int execute(String SQL) {
        int status = 0;
        Connection connect = setConnection();
        try {
            Statement st = connect.createStatement();
            status = st.executeUpdate(SQL);
        // Exception or error handling
        } catch (SQLException ex) {
            // If error = double primary key
            if(ex.getErrorCode() == 1062){
                return 2;
            } else{
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

    public static ResultSet executeQuery(String SQL) {
        ResultSet rs = null;
        Connection connect = setConnection();
        try {
            Statement st = connect.createStatement();
            rs = st.executeQuery(SQL);  
        // Exception or error handling
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    static Object GetConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Function for get qty column value from database
    public static int getQty(String table, String item){
        Connection connect = setConnection();
        try {
            Statement st = connect.createStatement();
            // SQL syntax to select all data from database
            String SQL = String.format("SELECT * FROM %s WHERE items = '%s'", table, item);
            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            int temp = rs.getInt("qty");
            return temp;
        // Exception or error handling
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    // Function for adding items to database
    public static int addItem(String table, Items temp){
        // SQL syntax to add items to database
        String sql = "INSERT INTO %s (items,type,qty,price,total_price) " 
                + "VALUES('%s', '%s', 1, %d, %d)";
        sql = String.format(sql, table, temp.items, temp.type, temp.price, temp.price);
        int status = Database.execute(sql);
        return status;
    }
    
    // Function for adding Qty column into Qty++
    public static int addQty(String table, Items temp){
        // Get the qty value from the database
        int qty = Database.getQty(table, temp.items);
        qty++;
        int total_price = qty*temp.price;
        // SQL syntax to update the total of qty
        String sql = "UPDATE %s SET qty = %d, total_price = %d WHERE items = '%s'";
        sql = String.format(sql, table, qty, total_price, temp.items);
        int status = Database.execute(sql);
        return status;
    }
    
    // Function for delete all data in a table
    public static int deleteAll(String table){
        try{
            // SQL syntax to delete all data on a table
            String sql = "TRUNCATE TABLE %s";
            sql = String.format(sql, table);
            Database.execute(sql);
        // Exception or error handling
        } catch(Exception e){
            return 0;
        }
        return 1;
    }
    
    // Function for login
    public static int login(String username, String password){
        try {
            // SQL syntax for login
            String sql = "SELECT * FROM tb_login WHERE username ='" + username + "' AND password='" + password + "'";
            ResultSet rs = executeQuery(sql);
            if(rs.next()){
                return 1;
            } else{
                return 2;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}