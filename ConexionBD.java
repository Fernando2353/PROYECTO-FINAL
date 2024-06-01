/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author miguelcatalan
 */
public class ConexionBD {
    
    private String url = "jdbc:postgresql://bubble.db.elephantsql.com:5432/yzfyxemq";
    private Properties properties = new Properties();
    private static Connection conn = null;
    
    private ConexionBD () {
        properties.setProperty("user", "yzfyxemq");
        properties.setProperty("password", "w0JR8Q0Df7msaE_YWDmChzxUeVO2GPUr");
        
        try {
            conn = DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        if (conn == null) {
               ConexionBD c = new ConexionBD();
               return c.conn;
        }
        else {
            return conn ;
        }
    }

}
