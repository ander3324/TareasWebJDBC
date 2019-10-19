package net.iterart.tareas.jdbc;

import java.sql.*;


/**
 *
 * @author ander
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tareas_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "wacaballa");
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
            return null;
        }
    }
}
