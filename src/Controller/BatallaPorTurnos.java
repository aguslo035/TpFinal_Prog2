package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;
import Models.GestorDeTextoDeCombate;

//"BatallaPorTurnos" maneja 1 solo combate entre un jugador y un enemigo. Recibe ambos de la clase JuegoRPG.
public abstract class BatallaPorTurnos {

    //atributos
    private static int ronda = 1;

    //métodos

    //devuelve true si ganó el jugador, devuelve false si perdió. JuegoRPG se encarga del final.
    public static boolean combateEntreEntidades(Jugador jugador, Enemigo enemigoActual)
    {
        System.out.println("Inicio de combate!\n\n");
        while (jugador.estaVivo())
        {
            System.out.println("==RONDA #"+ ronda +" ==\n");
            System.out.println(TurnoJugador.menuAtaque(jugador, enemigoActual));
            if (enemigoActual.estaVivo()) //si el enemigo no ha muerto en el turno del jugador, se le da lugar para que haga su acción.
            {
                System.out.println(TurnoEnemigo.accionEnemiga(jugador, enemigoActual));
            }else //caso contrario se sale del método avisando que murió.
            {
                ronda = 1; //lo setteo a 1 para el siguiente combate
                return true;
            }

            ronda++;
        }

        return false; //solo llegamos acá si el jugador muere (jugador.estaVivo da falso)
    }

    //Describe la vida, MP y escudo de el jugador y el enemigo. Lo devuelve como String.
    public static String estadoPelea(Jugador jugador, Enemigo enemigo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("===\n")
                .append(GestorDeTextoDeCombate.mostrarEstado(jugador))
                .append("\n===\n")
                .append(GestorDeTextoDeCombate.mostrarEstado(enemigo))
                .append("\n");
        return sb.toString();
    }


}
