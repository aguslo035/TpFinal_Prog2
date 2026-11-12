package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;


//La idea ahora mismo es que "BatallaPorTurnos" maneje 1 solo combate a la vez, no todos. JuegoRPG se encarga de mandar 1 por 1 los enemigos hasta que no haya más. Por eso elimino el arrayList de enemigoActual.
//también saco enemigo y jugador como atributos, porque todo lo recibe de JuegoRPG
public class BatallaPorTurnos {

    //atributos
    private static int ronda = 1;

    //métodos

    //devuelve true si ganó el jugador, devuelve false si perdió. JuegoRPG se encarga del final.
    public static boolean combateEntreEntidades(Jugador jugador, Enemigo enemigoActual)
    {
        System.out.println("\n\nInicio de combate!\n\n");
        while (jugador.estaVivo())
        {
            System.out.println("\n==RONDA #"+ ronda+ " ==\n\n");
            System.out.println(TurnoJugador.menuAtaque(jugador, enemigoActual));
            if (enemigoActual.estaVivo())
            {
                //falta la lógica de lo que hace cada enemigo :|
                //hay que hacer una clase que se encarge de recibir sus decisiones ("TurnoEnemigo")
                //Me voy a encargar de hacerla yo, porque se va a parecer bastante a TurnoJugador (solo que sin scanners), además va a llamar mucho a GestorDeTextoCombate)
            }else {
                ronda = 1; //lo setteo a 1 para el siguiente combate
                return true;
            }

            ronda++;
        }

        return false; //solo llegamos acá si jugador.estaVivo da falso (es decir, murió)
    }


}
