package Controller;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.ConstructorDeTextoParaTurnos.GestorDeTextoDeCombate;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.Scanner;


public abstract class TurnoJugador {

    //scanner
    private static final Scanner sc = new Scanner(System.in);//SIEMPRE se utiliza el scanner en el main con el metodo elegirOpcion()
    //cómo que en el main?

    //métodos

    //Muestra las opciones que tiene el jugador en su turno. Realiza acciones de acorde a su decisión. Devuelve texto de a corde a la acción realizada.
    public static String menuAtaque(Jugador jugador, Enemigo enemigo) //este se llama en turno usuario, así que ya se sabe qué entidad es cada uno (por eso especifico Jugador y Enemigo)
    {
        boolean continuar = false; //cambia al tomar acción que finalize el turno
        int decision;
        int aux; //recibe un número para mostrar después (ej, daño ocasionado, cuánto se curó, etc)
        String accionRealizada = null; //lo igualo a null para que java no se queje

        System.out.println(estadoPelea(jugador, enemigo)); //Muestra HP/MP/Escudo restante de los 2

        System.out.println(mostrarOpcionesCombate()); //le da a elegir al usuario

        while (!continuar)
        {
            decision = JuegoRPG.elegirOpcion();

            switch (decision)
            {
                case 0:
                    aux = jugador.atacar(enemigo);
                    continuar = true;
                    accionRealizada = GestorDeTextoDeCombate.ataque(jugador, enemigo, aux);
                    break;
                case 1:
                    accionRealizada = menuHabilidad(jugador, enemigo);
                    if (!accionRealizada.equals("Volver")) //significa que se tomó una decisión que finaliza el turno
                    {
                        continuar = true;
                    }
                    break;
                case 2:
                    accionRealizada = menuItems(jugador, enemigo);
                    if (!accionRealizada.equals("Volver"))
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
        return accionRealizada;
        //va a terminar devolviendo un flavor text: "X ataca a Y por 123 de daño!"
    }

    //Se listan todas las habilidades + opción de volver al menú de ataque. Una vez el usuario decide correctamente, devuelve un String indicando la elección realizada (que se realizó el ataque o se volvió al menú).
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
                    accionRealizada = GestorDeTextoDeCombate.ataqueHabilidad(jugador, enemigo, jugador.getHabilidades().get(decision).getNombre(), danioCausado);
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

    public static String menuItems(Jugador jugador, Enemigo enemigo)
    {
        boolean continuar = false;
        int decision;

        String accionRealizada = null; //inicializo en null para que no se queje java en el return

        do {
            System.out.println("===Items disponibles===\n\n");
            System.out.println(jugador.listarInventario());
            int i = jugador.contarItemsInventario();
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


//moví "elegirOpcion" a MenuInicial



    //este conviene esté en BatallaPorTurnos
    public static String estadoPelea(Jugador jugador, Enemigo enemigo) //muestra la vida, MP y efectos actuales de ambos
    {
        StringBuilder sb = new StringBuilder();
        sb.append("===")
                .append(GestorDeTextoDeCombate.mostrarEstado(jugador))
                .append("===")
                .append(GestorDeTextoDeCombate.mostrarEstado(enemigo))
                .append("\n\n");
        return sb.toString();
    }

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

    public static void cerrarScanner()
    {
        sc.close();
    }
}
