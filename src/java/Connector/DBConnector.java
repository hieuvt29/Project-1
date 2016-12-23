/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LOREMSUM
 */
public class DBConnector {
//Starting Index in ResultSet is 1
    
    private static String username = "root";
    private static String password = "123321@@";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //load driver
        Class.forName("com.mysql.jdbc.Driver");
        //init a connection to database that we need
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang", username, password);
        return con;
    }
}

