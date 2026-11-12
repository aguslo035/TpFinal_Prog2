package Controller;

import Enumerator.EAccionEnemigo;
import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;
import Models.GestorDeTextoDeCombate;
import Models.Habilidades.Habilidad;

public abstract class TurnoEnemigo {

    public static String accionEnemiga(Jugador jugador, Enemigo enemigo)
    {
        int aux; //recibe un número para mostrar después (por ej, daño ocasionado, vida/maná curada)
        String resultadoAccion = null; //inicializo en null para que java no se queje

        EAccionEnemigo decisionTomada = enemigo.elegirAccion();

        switch (decisionTomada) //si alguna vez agregamos una acción nueva enemiga, hay que agregar otro switch
        {
            case ATACAR:
                aux = enemigo.atacar(jugador);
                resultadoAccion = GestorDeTextoDeCombate.ataque(enemigo, jugador, aux);
                break;
            case USAR_HABILIDAD:
                resultadoAccion = ataqueConHabilidad(jugador, enemigo);
                break;
        }

        return resultadoAccion;
    }

    public static String ataqueConHabilidad(Jugador jugador, Enemigo enemigo)
    {
        String resultadoAccion = null;

        try{
            Habilidad habilidadElegida = enemigo.elegirHabilidadAUsar();
            int danioCausado = habilidadElegida.usar(enemigo, jugador);
            if (habilidadElegida.getNombre().equals("Robo de Vida"))
            {
                resultadoAccion = GestorDeTextoDeCombate.ataqueHabilidadConCura(enemigo, jugador, "Robo de Vida", danioCausado, danioCausado);
            }else {
                resultadoAccion = GestorDeTextoDeCombate.ataqueHabilidad(enemigo, jugador, habilidadElegida.getNombre(), danioCausado);
            }
        } catch (ManaInsuficienteException e) { //no puede pasar nunca porque el enemigo solo tiene acceso a las habilidades para las que tiene maná. Igual le agrego el mensaje
            System.out.println(e.getMessage() + " El enemigo utilizó una habilidad sin maná.");
        }

        return resultadoAccion;
    }
}
