package Controller;

import Exception.Conexion.ConexionException;
import Jdbc.ConexionClases;
import Jdbc.ConexionEnemigos;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.List;

public abstract class GestoraEntidadesYaCargadas { // es para traer las entidades que ya van a estar precargadas del juego
    // tambien, los metodos de meter a la base de datos o crear tabla no los tiene que usar el usuario, eso lo usamos para cargar
    // nosotros entidades a la base de datos para que despues el juego se arme solo nada mas
    public static List<Jugador> jugadores(){
        try {
            List<Jugador> jugadores = ConexionClases.traerClases();
        } catch (ConexionException e) {
            System.out.println(e.getMessage());
        }
        return jugadores();
    }

    public static List<Jugador> enemigos(){
        try {
            List<Enemigo> enemigos = ConexionEnemigos.traerEnemigos();
        } catch (ConexionException e) {
            System.out.println(e.getMessage());
        }
        return enemigos();
    }
}
