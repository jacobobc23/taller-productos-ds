/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author jacobobc
 */
public class DBConnection {

    private static final String URL = "jdbc:mariadb://localhost:3306/ds_taller1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static DBConnection INSTANCE;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBConnection getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DBConnection();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
    }

}
