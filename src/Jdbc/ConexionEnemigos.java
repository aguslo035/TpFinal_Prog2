package Jdbc;

import Exception.Conexion.ConexionException;
import Models.Entidades.Enemigos.Bestia;
import Models.Entidades.Enemigos.Demonio;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.Enemigos.Orco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionEnemigos extends Conexion {

    public static int crearTablaEnemigos()
        throws ConexionException {
        String query = "CREATE TABLE IF NOT EXISTS enemigo (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    tipo VARCHAR(20) NOT NULL,\n" +
                "    nombre VARCHAR(50) NOT NULL,\n" +
                "    vidaMaxima INT NOT NULL,\n" +
                "    manaMaximo INT NOT NULL,\n" +
                "    ataque INT NOT NULL,\n" +
                "    escudo INT NOT NULL\n" +
                ");";

        try (Connection conn = Conexion.createConnection() ; // Try with resources cierra solo por el autocloseable
            PreparedStatement ps = conn.prepareStatement(query)){ // lo mismo con el ps, cierra solo.

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexionException("Al crear la tabla de enemigos! " + e.getMessage());
        }
    }

    public static int importarEnemigo(Enemigo enemigo)
            throws ConexionException
    {
        String query = "INSERT INTO enemigo (tipo, nombre, vidaMaxima, manaMaximo, ataque, escudo)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = Conexion.createConnection() ;
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, enemigo.getClass().getSimpleName()); //obtengo el nombre de la clase para diferenciarlo y no hacer un enum
            ps.setString(2, enemigo.getNombre());
            ps.setInt(3, enemigo.getVidaMaxima());
            ps.setInt(4, enemigo.getManaMaximo());
            ps.setInt(5, enemigo.getAtaque());
            ps.setInt(6, enemigo.getEscudo());

            return ps.executeUpdate();
        }catch (SQLException e) {
            throw new ConexionException("Al importar enemigo! " + e.getMessage());
        }
    }

    public static List<Enemigo> traerEnemigos()
            throws ConexionException
    {
        List<Enemigo> enemigosDeBdd = new ArrayList<>();
        String query = "SELECT * FROM enemigo ORDER BY id;"; // ya ordenadas vienen

        try(Connection conn = Conexion.createConnection() ;
            PreparedStatement ps = conn.prepareStatement(query) ;
            ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                String claseEnemiga = rs.getString("tipo");
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int vidaMaxima = rs.getInt("vidaMaxima");
                int manaMaximo = rs.getInt("manaMaximo");
                int ataque = rs.getInt("ataque");
                int escudo = rs.getInt("escudo");

                switch (claseEnemiga) // dependiendo de la clase con la que se guardo se crea un enemigo de esa clase
                {
                    case "Orco":
                        enemigosDeBdd.add(new Orco(id, nombre, vidaMaxima, vidaMaxima, manaMaximo, manaMaximo, ataque, escudo));
                        break;
                    case "Bestia":
                        enemigosDeBdd.add(new Bestia(id, nombre, vidaMaxima, vidaMaxima, manaMaximo, manaMaximo, ataque, escudo));
                        break;
                    case "Demonio":
                        enemigosDeBdd.add(new Demonio(id, nombre, vidaMaxima, vidaMaxima, manaMaximo, manaMaximo, ataque, escudo));
                        break;
                }
            }
        } catch (SQLException e) {
            throw new ConexionException("Al traer las filas de enemigos! " + e.getMessage());
        }
        return enemigosDeBdd;
    }
}
