package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mysql {

    private static Connection connection;
    
    static {
        try {
            connect("localhost", "root", "Same2u", "shop_db");
        } catch (Exception ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void connect(String host, String username, String password, String database) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "", username, password);
    }

    public static boolean checkConnection() {
        if (connection == null) {
            return false;
        }
        return true;
    }

    public static void closeConnection() throws Exception {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(String query) throws Exception {
        run(query);
    }

    public static void update(String query) throws Exception {
        run(query);
    }

    public static void delete(String query) throws Exception {
        run(query);
    }

    public static ResultSet search(String query) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    private static void run(String query) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
