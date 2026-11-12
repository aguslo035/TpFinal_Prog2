package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.ArrayList;

public class BatallaPorTurnos {

    //atributos
    private ArrayList<Enemigo> enemigos; //tampoco sé si tener el listado de enemigo en la gestión de turnos, pero tampoco quiero complicarnos tercerizando la lógica aún más (ej, haciendo otra clase de juego que recién ahí invoque batalla por turnos)
    private Jugador jugador;
    private Enemigo enemigoActual;
    private int ronda;

    //métodos


}
