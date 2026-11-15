package Controller;

import Enumerator.EAccionEnemigo;
import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;
import Models.GestorDeTextoDeCombate;
import Models.Habilidades.Habilidad;

public abstract class TurnoEnemigo {

    //Gestiona la acción tomada por el enemigo. Devuelve un String describiendole al usuario la acción realizada.
    public static String accionEnemiga(Jugador jugador, Enemigo enemigo)
    {
        DanioOcasionado danioRealizado;
        int aux; //recibe un número para mostrar después (por ej, vida/maná curada)
        String resultadoAccion = null; //inicializo en null para que java no se queje

        EAccionEnemigo decisionTomada = enemigo.elegirAccion();

        boolean continuar = false;

        while (!continuar)
        {
            switch (decisionTomada) //si alguna vez agregamos una acción nueva enemiga, hay que agregar otro switch
            {
                case ATACAR:
                    danioRealizado = enemigo.atacar(jugador);
                    resultadoAccion = GestorDeTextoDeCombate.ataque(enemigo, jugador, danioRealizado);
                    continuar = true;
                    break;
                case USAR_HABILIDAD:
                    resultadoAccion = ataqueConHabilidad(jugador, enemigo);
                    if (resultadoAccion == null) //ocurre si el enemigo elije usar una habilidad pero no tiene maná suficiente para ninguna. Lo obliga a atacar.
                    {
                        decisionTomada = EAccionEnemigo.ATACAR;
                    }else //si pudo usar una habilidad, se procede a terminar el loop y finalizar el turno
                    {
                        continuar = true;
                    }
                    break;
            }
        }

        return resultadoAccion;
    }

    //Gestiona el ataque en caso de que el enemigo pueda y quiera usar una habilidad. Devuelve un String describiendo qué ocurrió al realizarla.
    public static String ataqueConHabilidad(Jugador jugador, Enemigo enemigo)
    {
        String resultadoAccion = null;

        try{
            Habilidad habilidadElegida = enemigo.elegirHabilidadAUsar(); //A partir de un array de habilidades para las cuales el enemigo tiene maná para usar, elige una aleatoriamente.
            if (habilidadElegida == null) //En caso de no tener maná suficiente para ninguna habilidad, habilidadElegida es null
            {
                resultadoAccion = null;
            }else
            {
                int pos = enemigo.getHabilidades().indexOf(habilidadElegida); //busco la posición de la habilidad que eligió
                DanioOcasionado danioRealizado = enemigo.usarHabilidad(pos, jugador);
                resultadoAccion = habilidadElegida.describirComportamiento(enemigo, jugador, danioRealizado);
            }
        } catch (ManaInsuficienteException e) { //no puede pasar nunca porque el enemigo solo tiene acceso a las habilidades para las que tiene maná. Igual le agrego el mensaje
            System.out.println(e.getMessage() + " El enemigo utilizó una habilidad sin maná."); //^ dije no puede pasar nunca y pasó igual lol
        }

        return resultadoAccion;
    }
}
