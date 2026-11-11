package Jdbc;

import Exception.Conexion.ConexionException;

import java.sql.*;

public abstract class Conexion {

    private static final String url = "67";
    private static final String user = "";
    private static final String password = "";

    private static Connection conn;

    public static Connection createConnection()
            throws ConexionException
    {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ConexionException("Al abrir conexion! " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection()
            throws ConexionException
    {
        try{
           conn.close();
        } catch (SQLException e) {
            throw new ConexionException("Al cerrar conexion! " + e.getMessage());
        }
    }

}
