package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import javax.swing.*;
import java.util.Scanner;

public class TurnoJugador {

    //scanner
    Scanner sc;

    //constructor
    public TurnoJugador() {
        sc = new Scanner(System.in);
    }

    //métodos
    public String menuAtaque(Jugador jugador, Enemigo enemigo) //este metodo lo llaman en el turno usuario, así que ya se sabe qué entidad es cada uno (por eso especifico Jugador y Enemigo)
    {
        boolean continuar = false; //solo cambia al finalizar una acción que termina el turno
        int decision = 0; //para el menú
        int aux; //recibe un número para mostrar después (ej, daño ocasionado, cuánto se curó, etc)
        StringBuilder accion = new StringBuilder(jugador.getNombre());

        System.out.println(estadoPelea(jugador, enemigo)); //Muestra HP/MP/Escudo restante de los 2

        System.out.println(mostrarOpciones()); //le da a elegir al usuario

        while (!continuar)
        {
            sc.nextInt(decision);
            sc.nextLine();

            switch (decision)
            {
                case 0:
                    int aux = jugador.atacar(enemigo);
                    continuar = true;
                    accion.append(" ataca a " + enemigo.getNombre() + "por "+ aux +" de daño!");
                case 1:
                    menuHabilidad(jugador, enemigo);
                case 2:

                    //llama a un metodo de menu de items
                case 3:



            }
        }


        return accion;
        //va a terminar devolviendo un flavor text: "X ataca a Y por 123 de daño!"
    }

    public int menuHabilidad(Jugador jugador, Enemigo enemigo)
    {
        System.out.println("===Habilidades disponibles===\n\n");
        int i = jugador.contarHabilidades();
        System.out.println();
        jugador.verHabilidades();

        System.out.println("\n");
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
