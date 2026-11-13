package Controller;

import Exception.Conexion.ConexionException;
import Jdbc.ConexionClases;
import Jdbc.ConexionEnemigos;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.Entidad;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.List;

public abstract class GestoraEntidadesYaCargadas { // es para traer las entidades que ya van a estar precargadas del juego
    // tambien, los metodos de meter a la base de datos o crear tabla no los tiene que usar el usuario, eso lo usamos para cargar
    // nosotros entidades a la base de datos para que despues el juego se arme solo nada mas
    public static List<Jugador> jugadores(){
        List<Jugador> jugadores = null;

        try {
            jugadores = ConexionClases.traerClases();
        } catch (ConexionException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }

    public static List<Enemigo> enemigos(){

        List<Enemigo> enemigos = null;

        try {
            enemigos = ConexionEnemigos.traerEnemigos();
        } catch (ConexionException e) {
            System.out.println(e.getMessage());
        }

        return enemigos;
    }

    //consideré hacerlo genérico (ej, List<? extends Entidad>) por el hipotético caso que algún día queramos también listar enemigos. Me dio tanta flojera pensarlo que lo dejé en jugadores, pero acá hay otro potencial uso de genericidad (usando el comodín)
    //necesito que me devuelva un String lindo contando de cada jugador del array del #0 hasta el que haya para que el usuario pueda elegir
    //Devuelve un String listando todos los personajes disponibles. Utiliza un metodo que indica atributos relevantes de los personajes.
    public static String listarPersonajes (List<Jugador> jugadores)
    {
        StringBuilder sb = new StringBuilder();
        int contador = 0;

        for (Jugador aux : jugadores)
        {
            sb.append("#"+ contador +" - ");
            sb.append(aux.datosParaEleccion());
            sb.append("\n");
        }

        return sb.toString();
    }
}
