package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.Scanner;

public class TurnoJugador {

    //scanner
    Scanner sc;

    //constructor
    public TurnoJugador() {
        sc = new Scanner(System.in);
    }

    //métodos
    public int menuAtaque(Jugador jugador, Enemigo enemigo) //este metodo lo llaman en el turno usuario, así que ya se sabe qué entidad es cada uno (por eso especifico Jugador y Enemigo)
    {
        int decision = 0;

//        System.out.println(estadoPelea(jugador, enemigo)); esto conviene esté en BatallaPorTurnos

        System.out.println(mostrarOpciones());

        sc.nextInt(decision);
        sc.nextLine();

        return decision;


    }

    //este conviene esté en BatallaPorTurnos
    public String estadoPelea(Jugador jugador, Enemigo enemigo) //muestra la vida, MP y efectos actuales de ambos
    {
        StringBuilder sb = new StringBuilder();
        sb.append("===")
                .append(jugador.mostrarEstado())
                .append("===")
                .append(enemigo.mostrarEstado())
                .append("\n\n");
        return sb.toString();
    }

    public String mostrarOpciones()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("==OPCIONES==\n\n")
                .append("0. Atacar.\n")
                .append("1. Habilidades.\n")
                .append("2. Inventario\n")
                .append("3. Inspeccionar Enemigo.\n");

        return sb.toString();
    }



}
