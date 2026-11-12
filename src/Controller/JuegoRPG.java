package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//eventualmente le quiero agregar el MenuAdmin
public abstract class JuegoRPG {

    private static List<Jugador> clasesAElegir = new ArrayList<>();
    private static List<Enemigo> enemigos = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void inicioJuego()
    {
        clasesAElegir = GestoraEntidadesYaCargadas.jugadores();
        enemigos = GestoraEntidadesYaCargadas.enemigos();

        int opcion;
        Jugador jugadorElegido;

        while(true)
        {
            System.out.println(menuOpciones());

            opcion = elegirOpcion();

            switch (opcion)
            {
                case 1:
                    jugadorElegido = menuEleccionClase();
                    aventura(jugadorElegido, enemigos);
                    break;
                case 2:
                    System.exit(0); //sale del programa. el "0" indica que es un cierre normal
                    break;
                case 3:
                    sc.close();
                    //menu admin
                    break;
                default:
                    System.out.println("Elija una opción valida.");
                    break;
            }
        }
    }

    public static void aventura(Jugador jugadorElegido, List<Enemigo> enemigos)
    {
        System.out.println(historiaInicial(jugadorElegido));

        boolean ganar;
        int cantidadDeBatallas = enemigos.size();
        int enemigoActual = 0;

        while(enemigoActual < cantidadDeBatallas)
        {
            System.out.println(encuentroEnemigo(jugadorElegido, enemigos.get(enemigoActual))); //Texto de encuentro.
            ganar = BatallaPorTurnos.combateEntreEntidades(jugadorElegido, enemigos.get(enemigoActual)); //Ocurre batalla

        }

    }

    //Estoy tan embolado de modularizar tanto que simplemente voy a crear un objeto del tiem que elija y agregarselo al inventario
    //Está mal porque por cada item que agregemos hay que modificar este método
    //Pero modularizé tanto que me marié y esto requiere de una solución más compleja (pensé que cada enemigo dropeaba un item y me hacía la vida fácil, pero lo habíamos cambiado para que el usuario elija de los items que existen)
    public void recolectarRecompensa(Jugador jugadorElegido)
    {
        System.out.println();
    }

    public String recompensasDisponibles()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("");
    }




    public static String encuentroEnemigo(Jugador jugadorElegido, Enemigo enemigo)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\nEn el trayecto, "+ jugadorElegido.getNombre() + " se encuentra con "+ enemigo.getNombre() + "...\n");
        sb.append("¡Que se prepare para pelear!\n\n");

        return sb.toString();
    }

    public static String historiaInicial (Jugador jugadorElegido)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\n¡"+ jugadorElegido.getNombre() + " embarca en su aventura para ser el más fuerte!\n");
        sb.append("En su viaje se encontrará con distintos enemigos que buscarán su muerte.\n");

        return sb.toString();
    }

    public

    public static String menuOpciones()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("==EL MEJOR JUEGO RPG==\n");
        sb.append("INICIO\n\n");
        sb.append("1. JUGAR\n");
        sb.append("2. SALIR\n");
        sb.append("3. MENU ADMIN\n");

        sb.append("\nSu decision: ");

        return sb.toString();
    }

    public static Jugador menuEleccionClase() //todo: una vez esté hecho el toString en "GestoraEntidadesYaCargadas" lo completo
    {
        StringBuilder sb = new StringBuilder();

        Jugador jugadorElegido;

        sb.append(clasesAElegir);

        int decision = elegirOpcion();

        //un while true hasta que eliga una opción válida (voy a copiar la lógica de lo que hice en TurnoJugador con menú de habilidades e items)

        //eventualmente devuelvo el jugador que se eligió dentro de los switches del while
        return jugadorElegido;
    }

    public static int elegirOpcion() // ahi te lo arregle que tenia un par de errores y tmb maneja para que no se corte si ingresan algo que no es un Int
    {
        int decision;

        do {
            System.out.println("Seleccione una de las opciones: ");
            try {
                decision = sc.nextInt();
                return decision;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + "Ingrese un valor valido."); //e.get message no te tira el texto gigante?
            } finally {
                sc.nextLine();
            }
        } while (true) ;
    }





}
