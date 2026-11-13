package Jdbc;

import Enumerator.TipoArma;
import Exception.Conexion.ConexionException;
import Models.Entidades.JugadoresClases.Arquero;
import Models.Entidades.JugadoresClases.Guerrero;
import Models.Entidades.JugadoresClases.Jugador;
import Models.Entidades.JugadoresClases.Mago;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public abstract class ConexionClases extends Conexion{

    public static int crearTablaClases()
        throws ConexionException {
        String query = "CREATE TABLE IF NOT EXISTS personaje (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    tipo VARCHAR(20) NOT NULL,\n" +
                "    vidaMaxima INT NOT NULL,\n" +
                "    manaMaximo INT NOT NULL,\n" +
                "    ataque INT NOT NULL,\n" +
                "    escudo INT NOT NULL,\n" +
                "    tipoArma VARCHAR(20) NOT NULL,\n" +
                "    probabilidadCritica DOUBLE NOT NULL\n" + // todos tendran una prob critica de 0 en vez de poner que se permitan null
                ");";

        try (Connection conn = Conexion.createConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexionException("Al crear la tabla de clases! " + e.getMessage());
        }
    }

    public static int importarClase(Jugador jugador)
            throws ConexionException
    {
        String query = "INSERT INTO personaje (tipo, vidaMaxima, manaMaximo, ataque, escudo, tipoArma, probabilidadCritica)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (Connection conn = Conexion.createConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            double probCritica = 0; // solo el Arquero la tiene
            if (jugador instanceof Arquero arquero) {
                probCritica = arquero.getProbabilidadCritica();
            }

            ps.setString(1, jugador.getClass().getSimpleName());
            ps.setInt(2, jugador.getVidaMaxima());
            ps.setInt(3, jugador.getManaMaximo());
            ps.setInt(4, jugador.getAtaque());
            ps.setInt(5, jugador.getEscudo());
            ps.setString(6, jugador.getTipoArma().name());
            ps.setDouble(7, probCritica);

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new ConexionException("Al importar clase! " + e.getMessage());
        }
    }

    public static List<Jugador> traerClases()
            throws ConexionException
    {
        List<Jugador> clasesDeBdd = new ArrayList<>();
        String query = "SELECT * FROM personaje ORDER BY id;";

        try (Connection conn = Conexion.createConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                String clase = rs.getString("tipo");
                int id = rs.getInt("id");
                int vidaMaxima = rs.getInt("vidaMaxima");
                int manaMaximo = rs.getInt("manaMaximo");
                int ataque = rs.getInt("ataque");
                int escudo = rs.getInt("escudo");
                TipoArma tipoArma = TipoArma.valueOf(rs.getString("tipoArma")); // te selecciona el enum con la string que este dentro de valueof
                double probabilidadCritica = rs.getDouble("probabilidadCritica");

                String nombre = " Clase recuperada de la base de datos "; // el jugador lo cambia después con setNombre lo demas no varia

                switch (clase)
                {
                    case "Guerrero":
                        clasesDeBdd.add(new Guerrero(id, nombre, vidaMaxima, vidaMaxima, manaMaximo, manaMaximo, ataque, escudo, tipoArma));
                        break;
                    case "Arquero":
                        clasesDeBdd.add(new Arquero(id, nombre, vidaMaxima, vidaMaxima, manaMaximo, manaMaximo, ataque, escudo, tipoArma, probabilidadCritica));
                        break;
                    case "Mago":
                        clasesDeBdd.add(new Mago(id, nombre, vidaMaxima, vidaMaxima, manaMaximo, manaMaximo, ataque, escudo, tipoArma));
                        break;
                }
            }
        } catch (SQLException e) {
            throw new ConexionException("Al traer las filas de clases! " + e.getMessage());
        }
        return clasesDeBdd;
    }
}