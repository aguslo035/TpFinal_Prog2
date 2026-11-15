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
        System.out.println("\nINICIO ACCION ENEMIGA\n");
        DanioOcasionado danioRealizado;
        System.out.println("\nEsto es inmediatamente después de danioRealizado a ver si es el problema\n");
        int aux; //recibe un número para mostrar después (por ej, vida/maná curada)
        String resultadoAccion = null; //inicializo en null para que java no se queje

        EAccionEnemigo decisionTomada = enemigo.elegirAccion();
        System.out.println("\nEsto es inmediatamente después de que el enemigo tome la decisión a ver si es el problema\n");

        boolean continuar = false;

        while (!continuar)
        {
            System.out.println("\nAcabo de entrar al while del !continuar del turnoenemigo a ver si es el problema\n");
            switch (decisionTomada) //si alguna vez agregamos una acción nueva enemiga, hay que agregar otro switch
            {
                case ATACAR:
                    System.out.println("\nentré a switch atacar de enemigo\n");
                    danioRealizado = enemigo.atacar(jugador);
                    resultadoAccion = GestorDeTextoDeCombate.ataque(enemigo, jugador, danioRealizado);
                    System.out.println("\nestoy por settear el continuar en true del ataque enemigo\n");
                    continuar = true;
                    break;
                case USAR_HABILIDAD:
                    System.out.println("\nEntré al caso de usar habilidad.\n");
                    resultadoAccion = ataqueConHabilidad(jugador, enemigo);
                    if (resultadoAccion == null) //ocurre si el enemigo elije usar una habilidad pero no tiene maná suficiente para ninguna. Lo obliga a atacar.
                    {
                        System.out.println("\nEl muchacho no tiene maná para sus habilidades, entro en el if y ataca.\n");
                        decisionTomada = EAccionEnemigo.ATACAR;
                    }else
                    {
                        System.out.println("\nEl enemigo decidió usar una habilidad\n");
                        continuar = true;
                    }
                    break;
            }
        }

        System.out.println("\nFIN ACCION ENEMIGA\n");
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
