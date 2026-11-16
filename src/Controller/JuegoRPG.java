package Controller;

import Enumerator.ETipoArma;
import Jdbc.Conexion;
import Models.Entidades.Enemigos.Bestia;
import Models.Entidades.Enemigos.Demonio;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.Enemigos.Orco;
import Models.Entidades.JugadoresClases.Arquero;
import Models.Entidades.JugadoresClases.Guerrero;
import Models.Entidades.JugadoresClases.Jugador;
import Models.Entidades.JugadoresClases.Mago;
import Models.Items.Pociones.PocionMana;
import Models.Items.Pociones.PocionVida;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//La clase principal del juego. A partir de ella se llaman todos los métodos.
public abstract class JuegoRPG {

    //atributos
//    private static List<Jugador> clasesAElegir = new ArrayList<>();
//    private static List<Enemigo> enemigos = new ArrayList<>();
    private static List<Jugador> clasesAElegir = GestoraEntidadesYaCargadas.jugadores();
    private static List<Enemigo> enemigos = GestoraEntidadesYaCargadas.enemigos(); // ESTOS DOS ATRIBUTOS SON LOS QUE VAMOS A USAR, LOS DE ARRIBA SON DE PRUEBA
    private static Scanner sc = new Scanner(System.in); // el unico scanner que vamos a usar

    //métodos

    //Es un métod o prueba. Eliminar después y descomentar el inicio de .inicioJuego(). Carga en el array de clase personajes y enemigos.
//    public static void testJugadoresYEnemigos()
//    {
//        Guerrero clase1 = new Guerrero(1, "Emma el Guerrero", 100, 100, 100, 100, 20, 100, ETipoArma.ESPADA);
//        Mago clase2 = new Mago(2, "Lucre la Maga", 100, 100, 100, 100, 15, 100, ETipoArma.BASTON);
//        Arquero clase3 = new Arquero(3, "Legolas el Arquero", 100, 100, 100, 100, 20, 80, ETipoArma.ARCO, 0.50);
//        Guerrero clase4 = new Guerrero(4, "Goku", 10000, 10000, 10000, 10000, 2000, 10000, ETipoArma.NINGUNA);
//
//        clasesAElegir.add(clase1);
//        clasesAElegir.add(clase2);
//        clasesAElegir.add(clase3);
//        clasesAElegir.add(clase4);
//
//        Bestia enemigo1 = new Bestia(1, "Firulais la Bestia", 50, 50, 60, 60, 10, 40);
//        Orco enemigo2 = new Orco(2, "Bernard el Orco", 60, 60 , 70, 70, 20, 30);
//        Demonio enemigo3 = new Demonio(3, "Adrian el Rey Demonio", 70, 70, 80, 80, 25, 40);
//
//        enemigos.add(enemigo1);
//        enemigos.add(enemigo2);
//        enemigos.add(enemigo3);
//    }

    //Métod o principal, a partir de él se comienzan a llamar métodos. Lista las opciones incialmente disponibles.
    public static void inicioJuego()
    {

        int opcion;
        Jugador jugadorElegido;

        while(true)
        {
            System.out.println(menuOpciones());

            opcion = elegirOpcion(); //scanner

            switch (opcion)
            {
                case 1:
                    jugadorElegido = menuEleccionClase(); // devuelve un jugador
                    aventura(jugadorElegido, enemigos);
                    break;
                case 2:
                    sc.close();
                    System.exit(0); //sale del programa. el "0" indica que es un cierre normal
                    break;
                default:
                    System.out.println("Elija una opción valida.\n");
                    break;
            }
        }
    }

    //Representa una partida una vez elegido personaje. Mantiene anotado cuántos enemigos hay y cuántos faltan para la victoria.
    public static void aventura(Jugador jugadorElegido, List<Enemigo> enemigos)
    {
        System.out.println(historiaInicial(jugadorElegido));

        boolean ganar;
        int cantidadDeBatallas = enemigos.size();
        int enemigoActual = 0;

        while(enemigoActual < cantidadDeBatallas) //La aventura continúa mientras se tengan enemigos.
        {
            System.out.println(encuentroEnemigo(jugadorElegido, enemigos.get(enemigoActual))); //Texto de encuentro.
            ganar = BatallaPorTurnos.combateEntreEntidades(jugadorElegido, enemigos.get(enemigoActual)); //Ocurre batalla

            if(ganar)
            {
                System.out.println(recolectarRecompensa(jugadorElegido));
                enemigoActual++; //avanzamos al siguiente enemigo
            }else //se perdió
            {
                System.out.println(derrotaJugador(jugadorElegido));
                sc.nextLine(); //esto le da una pausa al jugador antes de que se cierre el juego.
                sc.close();
                System.exit(0);
            }
        }

        //solo se llega a este punto si no se ha muerto el jugador (todos los enemigos han sido derrotados)
        System.out.println(victoriaAnteLosMonstruos(jugadorElegido));
        sc.nextLine(); //esto le da una pausa al jugador antes de que se cierre el juego.
        sc.close();
        System.exit(0);
    }

    //Texto que representa el final de la partida por victoria. Se devuelve como String.
    public static String victoriaAnteLosMonstruos(Jugador jugadorElegido)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\n"+ jugadorElegido.getNombre() + " ha derrotado a todos los enemigos en su camino.\n");
        sb.append("Ha demostrado ser uno de los mejores "+ jugadorElegido.getClass().toString() + "s de todos los tiempos...\n\n");
        sb.append("FIN DEL JUEGO. VICTORIA.\n");

        return sb.toString();
    }

    //Texto que representa el final de la partida por derrota. Se devuelve como String.
    public static String derrotaJugador(Jugador jugadorElegido)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\nCon su vida en 0, "+ jugadorElegido.getNombre() + " es derrotado por el monstruo...\n");
        sb.append("Hasta aquí ha llegado su aventura...\n\n");
        sb.append("FIN DEL JUEGO. DERROTA.\n");

        return sb.toString();
    }

    //Indica un listado de los items existentes. Una vez se elije uno, se agrega al inventario, y se indica qué es eligió devolviendo un String.
    public static String recolectarRecompensa(Jugador jugadorElegido)
    {
        System.out.println(jugadorElegido.getNombre() + " ha vencido al rival... ¡Ahora procede a recolectar el tesoro!\n");
        System.out.println(recompensasDisponibles());

        boolean continuar = false;

        String accionRealizada = null; //inicalizo en null para que java no se queje

        while(!continuar)
        {
            int decision = elegirOpcion();

            switch (decision)
            {
                case 1:
                    PocionVida pocionDeVida = new PocionVida();
                    jugadorElegido.agregarItem(pocionDeVida);
                    accionRealizada = "Se ha agregado una poción de vida a su inventario.\n";
                    continuar = true;
                    break;
                case 2:
                    PocionMana pocionDeMana = new PocionMana();
                    jugadorElegido.agregarItem(pocionDeMana);
                    accionRealizada = "Se ha agregado una poción de maná a su inventario.\n";
                    continuar = true;
                    break;
                default:
                    System.out.println("Elija una opción valida.\n\n");
            }
        }

        return accionRealizada;
    }

    //Devuelve como String los items habilitados como recompensa.
    public static String recompensasDisponibles()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\n==Items Disponibles==\n\n");
        sb.append("1. Pocion de vida.\n");
        sb.append("2. Pocion de maná\n\n");

        return sb.toString();
    }

    //Devuelve texto introductorio de un combate.
    public static String encuentroEnemigo(Jugador jugadorElegido, Enemigo enemigo)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\nEn el trayecto, "+ jugadorElegido.getNombre() + " se encuentra con "+ enemigo.getNombre() + "...\n");
        sb.append("¡Que se prepare para pelear!\n\n");

        return sb.toString();
    }

    //Devuelve un String indicando el principio de la historia.
    public static String historiaInicial (Jugador jugadorElegido)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\n¡"+ jugadorElegido.getNombre() + " embarca en su aventura para ser el más fuerte!\n");
        sb.append("En su viaje se encontrará con distintos enemigos que buscarán su muerte.\n");

        return sb.toString();
    }

    //Devuelve como String las opciones del menú principal.
    public static String menuOpciones()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("==EL MEJOR JUEGO RPG==\n");
        sb.append("INICIO\n\n");
        sb.append("1. JUGAR\n");
        sb.append("2. SALIR\n");

        return sb.toString();
    }

    //Menú para que el usuario elija la clase/personaje que desea usar. Devuelve el personaje elegido.
    public static Jugador menuEleccionClase()
    {
        System.out.println("\n==PERSONAJES DISPONIBLES==\n");
        String clasesDisponibles = GestoraEntidadesYaCargadas.listarPersonajes(clasesAElegir);
        System.out.println(clasesDisponibles);

        int cantClases = clasesAElegir.size();

        Jugador jugadorElegido;

        while (true)
        {
            int decision = elegirOpcion();

            if (decision < cantClases && decision >= 0)
            {
                return jugadorElegido = clasesAElegir.get(decision);
            }else
            {
                System.out.println("Por favor elija una de las opciones.\n");
            }
        }
    }

    public static int elegirOpcion()
    {
        int decision;

        do {
            System.out.println("Seleccione una de las opciones: ");
            try {
                decision = sc.nextInt();
                return decision;
            } catch (InputMismatchException e) { // lo ingresado no corresponde con un Integrer, tira esa excepcion
                System.out.println("\nIngrese un valor valido.\n");
            } finally {
                sc.nextLine();
            }
        } while (true) ;
    }
}
