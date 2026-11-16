package Controller;

import Exception.Conexion.ConexionException;
import Jdbc.ConexionClases;
import Jdbc.ConexionEnemigos;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.Entidad;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.List;

//Obtiene las entidades ya cargadas en la base de datos.
public abstract class GestoraEntidadesYaCargadas {

    //metodos

    //Intenta obtener y devolver el listado de jugadores dentro de la base de datos.
    public static List<Jugador> jugadores(){

        List<Jugador> jugadores = null;
        try {
            jugadores = ConexionClases.traerClases();
        } catch (ConexionException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }

    //Intenta obtener y devolver el listado de enemigos dentro de la base de datos.
    public static List<Enemigo> enemigos(){

        List<Enemigo> enemigos = null;

        try {
            enemigos = ConexionEnemigos.traerEnemigos();
        } catch (ConexionException e) {
            System.out.println(e.getMessage());
        }
        return enemigos;
    }

    //Devuelve un String listando todos los personajes disponibles dentro del array que se le otorge. Utiliza un metodo que indica atributos relevantes de los personajes.
    public static String listarPersonajes (List<Jugador> jugadores)
    {
        StringBuilder sb = new StringBuilder();
        int contador = 0;

        for (Jugador aux : jugadores)
        {
            sb.append("#"+ contador +" - ");
            sb.append(aux.datosParaEleccion());
            sb.append("\n");
            contador++;
        }

        return sb.toString();
    }
}
