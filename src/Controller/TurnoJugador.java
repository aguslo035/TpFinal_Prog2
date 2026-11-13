package Controller;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.GestorDeTextoDeCombate;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;
import Models.Habilidades.Habilidad;

import java.util.Scanner;


public abstract class TurnoJugador {

    //scanner
    private static final Scanner sc = new Scanner(System.in);//SIEMPRE se utiliza el scanner en el main con el metodo elegirOpcion()
    //cómo que en el main?

    //métodos

    //Muestra las opciones que tiene el jugador en su turno. Realiza acciones según su decisión. Devuelve texto de acorde a la acción realizada.
    public static String menuAtaque(Jugador jugador, Enemigo enemigo) //este se llama en turno usuario, así que ya se sabe qué entidad es cada uno (por eso especifico Jugador y Enemigo)
    {
        boolean continuar = false; //cambia al tomar acción que finalize el turno
        int decision;
        int aux; //recibe un número para mostrar después (ej, daño ocasionado, cuánto se curó, etc)
        String resultadoAccion = null; //lo igualo a null para que java no se queje

        while (!continuar)
        {
            System.out.println(BatallaPorTurnos.estadoPelea(jugador, enemigo)); //Muestra HP/MP/Escudo restante de los 2

            System.out.println(mostrarOpcionesCombate()); //le da a elegir al usuario

            decision = JuegoRPG.elegirOpcion();

            switch (decision)
            {
                case 0:
                    aux = jugador.atacar(enemigo);
                    continuar = true;
                    resultadoAccion = GestorDeTextoDeCombate.ataque(jugador, enemigo, aux);
                    break;
                case 1:
                    resultadoAccion = menuHabilidad(jugador, enemigo);
                    if (!resultadoAccion.equals("VOLVER")) //significa que se tomó una decisión que finaliza el turno
                    {
                        continuar = true;
                    }
                    break;
                case 2:
                    resultadoAccion = menuItems(jugador, enemigo);
                    if (!resultadoAccion.equals("VOLVER"))
                    {
                        continuar = true;
                    }
                    break;
                case 3: //descubrí que poniendo "todo" el texto se pone todo azul parece útil
                    System.out.println(enemigo.toString()); //TODO: hay que modificar el toString de Entidad para mostrar todas las habilidades tambien.
                    break; // todo se pone verde no azul ajdja
                default: //creo que porque uso el intellijet en blanco el color mío es azul
                    System.out.println("Por favor elija una de las opciones.");
                    break;
            }
        }

        return resultadoAccion; //ej resultado: "X ataca a Y por 123 de daño!"
    }

    //Lista todas las habilidades del jugador y una opción para volver al menú de ataque. Una vez el usuario tome una opción valida, devuelve un String indicando la elección realizada (que se realizó el ataque o se volvió al menú).
    public static String menuHabilidad(Jugador jugador, Enemigo enemigo)
    {
        boolean continuar = false;
        int decision;

        String accionRealizada = null; //inicializo en null para que java no se queje

        do {
            System.out.println("Maná actual: "+ jugador.getManaActual() + "\n\n");
            System.out.println("===Habilidades disponibles===\n\n");
            System.out.println(jugador.verHabilidades());
            int i = jugador.contarHabilidades();
            System.out.println("#"+i+" - Volver a Opciones");

            decision = JuegoRPG.elegirOpcion();

            if (decision == i)
            {
                accionRealizada = "VOLVER";
                continuar = true;
            }else
            {
                try {
                    int danioCausado = jugador.usarHabilidad(decision, enemigo);
                    //lo siguiente solo ocurre si no ocurrió una exception (elige opción valida)
                    accionRealizada = jugador.getHabilidades().get(decision).describirComportamiento(jugador, enemigo, danioCausado); //puede que esté mal que se busque la misma habilidad 2 veces, pero el .usarHabilidad del jugador en la linea de arriba hace la verificación de que tiene maná para usarla
                    continuar = true;
                } catch (IndiceInvalidoException e) {
                    System.out.println("Elija una opción valida de las mostradas.");
                } catch (ManaInsuficienteException e)
                {
                    System.out.println("Mana insuficiente.");
                }
            }

        }while (!continuar);

        return accionRealizada;
    }

    //Lista todas los items del jugador y una opción para volver al menú de ataque. Una vez el usuario tome una opción valida, devuelve un String indicando la elección realizada (que se realizó el ataque o se volvió al menú).
    public static String menuItems(Jugador jugador, Enemigo enemigo)
    {
        boolean continuar = false;
        int decision;

        String accionRealizada = null; //inicializo en null para que no se queje java en el return

        do {
            System.out.println("===Items disponibles===\n\n");
            System.out.println(jugador.listarInventario());
            int i = jugador.contarItemsInventario();
            System.out.println("\nAhora mismo hay "+ i + " items en su inventario.\n");
            System.out.println("#"+i+" - Volver a Opciones");

            decision = JuegoRPG.elegirOpcion();

            if (decision == i)
            {
                accionRealizada = "VOLVER";
                continuar = true;
            }else
            {
                try {
                    int cantAfectada = jugador.utilizarItem(decision); //esto lanza "IndiceNoValidoException"
                    //lo siguiente solo ocurre si no ocurrió una exception (elige opción valida)
                    accionRealizada = jugador.getInventario().obtenerElemento(decision).describirComportamiento(jugador, cantAfectada);
                    jugador.eliminarItem(decision); //al final lo elimino acá al item
                    continuar = true;
                } catch (IndiceInvalidoException e) {
                    System.out.println("Elija una opción valida de las mostradas.");
                }
            }

        }while (!continuar);

        return accionRealizada;
    }

    //este conviene esté en BatallaPorTurnos
    //

    //Consiste de un menú con las opcioens disponibles en el turno del usuario. Lo devuelve como String.
    public static String mostrarOpcionesCombate()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("==OPCIONES==\n\n")
                .append("0. Atacar.\n")
                .append("1. Habilidades.\n")
                .append("2. Inventario\n")
                .append("3. Inspeccionar Enemigo.\n");

        return sb.toString();
    }

    //Cierra el scanner.
    public static void cerrarScanner()
    {
        sc.close();
    }
}
