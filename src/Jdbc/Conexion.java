package Jdbc;
import java.sql.*;

public abstract class Conexion {

    private static final String url = "";
    private static final String user = "";
    private static final String password = "";

    private static Connection conn;

    public static Connection createConnection()
    {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection()
    {
        try{
           conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
