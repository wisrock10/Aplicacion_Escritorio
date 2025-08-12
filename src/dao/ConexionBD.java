/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author qadri
 */
public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=TareasDB";
    private static final String USER = "WISTON_JOSE";
    private static final String PASS = "123456";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
