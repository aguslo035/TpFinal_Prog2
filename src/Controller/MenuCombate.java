package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.Entidad;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.Scanner;

public class MenuCombate {

    //scanner
    Scanner sc;

    //constructor
    public MenuCombate() {
        sc = new Scanner(System.in);
    }

    //métodos
    public void menuAtaque(Jugador jugador, Enemigo enemigo) //este metodo lo llaman en el turno usuario, así que ya se sabe qué entidad es cada uno (por eso especifico Jugador y Enemigo)
    {
        boolean flag = true;
        int decision = 0;

        while (flag)
        {
            System.out.println(mostrarOpciones());
            sc.nextInt(decision);
            sc.nextLine();

            switch (decision) {
                case 0:

            }

        }



    }

    public String estadoPelea(Jugador jugador, Enemigo enemigo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("===");
        sb.append(jugador.mostrarEstado());
        sb.append("===");
        sb.append(enemigo.mostrarEstado());
        sb.append("\n\n");

        return sb.toString();
    }

    public String mostrarOpciones()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("==OPCIONES==\n\n");
        sb.append("0. Atacar.\n");
        sb.append("1. Habilidades.\n");
        sb.append("2. Inventario\n");
        sb.append("3. Inspeccionar Enemigo.\n");

        return sb.toString();
    }

    public void atacarEnemigo(Jugador jugador, Enemigo enemigo)
    {

    }


}
