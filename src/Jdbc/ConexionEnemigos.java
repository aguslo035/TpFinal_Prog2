package Jdbc;

import Models.Entidades.Enemigos.Enemigo;

import java.sql.*;

public class ConexionEnemigos extends Conexion {

    public static int crearTablaEnemigos() {
        String query = "CREATE TABLE IF NOT EXISTS enemigo (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    tipo VARCHAR(20) NOT NULL,\n" +
                "    nombre VARCHAR(50) NOT NULL,\n" +
                "    vidaMaxima INT NOT NULL,\n" +
                "    manaMaximo INT NOT NULL,\n" +
                "    ataque INT NOT NULL,\n" +
                "    defensa INT NOT NULL\n" +
                ");";

        try (Connection conn = Conexion.createConnection() ; // Try with resources cierra solo por el autocloseable
            PreparedStatement ps = conn.prepareStatement(query)){ // lo mismo con el ps, cierra solo.

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int importarEnemigo(Enemigo enemigo)
    {
        String query = "INSERT INTO enemigo (tipo, nombre, vidaMaxima, manaMaximo, ataque, defensa)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = Conexion.createConnection() ;
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, enemigo.getClass().getSimpleName()); //obtengo el nombre de la clase para diferenciarlo y no hacer un enum
            ps.setString(2, enemigo.getNombre());
            ps.setInt(3, enemigo.getVidaMaxima());
            ps.setInt(4, enemigo.getManaMaximo());
            ps.setInt(5, enemigo.getAtaque());
            ps.setInt(6, enemigo.getDefensa());

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
