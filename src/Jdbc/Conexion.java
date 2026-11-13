package Jdbc;

import Exception.Conexion.ConexionException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
//https://www.arquitecturajava.com/java-properties-files-y-como-usarlos/
// en esta pagina nos guiamos para poder leer el txt

public abstract class Conexion {

    private static final String url;
    private static final String user;
    private static final String password;

    static{ // static es lo primero que ejecuta esta clase
        Properties properties = new Properties(); // funciona como un map, hashtable tiene <Clave, Valor>
        try (FileInputStream in = new FileInputStream("jdbc.txt")) { // en el archivo se encuentra por ej url = html//asdasd siendo url la clave y luego del igual su valor
            properties.load(in); // Lee los bytes de un archivo ^^^^ y load arma el par clave valor  || tambien se utiliza try with resources por lo mismo que en las conexiones, tiene autocloseable y es mas seguro que si lo cerraramos nosotros
        } catch (IOException e) {
            System.out.println("No se pudo leer jdbc.txt. Mensaje: " + e.getMessage());
        }

        url = properties.getProperty("url"); // al igual que un map se utiliza un get para traer el valor dependiendo de la clave
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    public static Connection createConnection()
            throws ConexionException
    {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ConexionException("Al abrir conexion! " + e.getMessage());
        }
    }

    public static void closeConnection()
            throws ConexionException
    {
        try{
            DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.password).close();
        } catch (SQLException e) {
            throw new ConexionException("Al cerrar conexion! " + e.getMessage());
        }
    }

}
