package Controller;

import Enumerator.TipoArma;
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

//eventualmente le quiero agregar el MenuAdmin
public abstract class JuegoRPG {

    private static List<Jugador> clasesAElegir = new ArrayList<>();
    private static List<Enemigo> enemigos = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void testJugadoresYEnemigos()
    {
        Guerrero clase1 = new Guerrero(1, "Emma el Guerrero", 100, 100, 100, 100, 20, 100, TipoArma.ESPADA);
        Mago clase2 = new Mago(2, "Lucre la Maga", 100, 100, 100, 100, 15, 100, TipoArma.BASTON);
        Arquero clase3 = new Arquero(3, "Legolas el Arquero", 100, 100, 100, 100, 20, 80, TipoArma.ARCO, 0.50);

        clasesAElegir.add(clase1);
        clasesAElegir.add(clase2);
        clasesAElegir.add(clase3);

        Bestia enemigo1 = new Bestia(1, "Firulais la Bestia", 50, 50, 60, 60, 10, 40);
        Orco enemigo2 = new Orco(2, "Bernard el Orco", 60, 60 , 70, 70, 20, 30);
        Demonio enemigo3 = new Demonio(3, "Horacio el Rey Demonio", 70, 70, 80, 80, 25, 40);

        enemigos.add(enemigo1);
        enemigos.add(enemigo2);
        enemigos.add(enemigo3);
    }


    public static void inicioJuego()
    {
        //Esto lo voy a comentar en testeos, voy a hardcodear un array de jugadores y enemigos
        //clasesAElegir = GestoraEntidadesYaCargadas.jugadores();
        //enemigos = GestoraEntidadesYaCargadas.enemigos();

        testJugadoresYEnemigos(); //agrega a los listados los jugadores y enemigos que creé

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
                    sc.close(); //como esto llama al menú admin no hay que cerrar
                    //menu admin
                    break;
                default:
                    System.out.println("Elija una opción valida.");
                    break;
            }
        }
    }

    //va a batallar contra todos los enemigos que se han importado
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

            if(ganar)
            {
                System.out.println(recolectarRecompensa(jugadorElegido));
                enemigoActual++; //avanzamos al siguiente enemigo
            }else
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

    public static String victoriaAnteLosMonstruos(Jugador jugadorElegido)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\n"+ jugadorElegido.getNombre() + " ha derrotado a todos los enemigos en su camino.\n");
        sb.append("Ha demostrado ser uno de los mejores "+ jugadorElegido.getClass().toString() + "s de todos los tiempos...\n\n");
        sb.append("FIN DEL JUEGO. VICTORIA.\n");

        return sb.toString();
    }

    public static String derrotaJugador(Jugador jugadorElegido)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\nCon su vida en 0, "+ jugadorElegido.getNombre() + " es derrotado por el monstruo...\n");
        sb.append("Hasta aquí ha llegado su aventura...\n\n");
        sb.append("FIN DEL JUEGO. DERROTA.\n");

        return sb.toString();
    }

    //Estoy tan embolado de modularizar tanto que simplemente voy a crear un objeto del item que elija y agregarselo al inventario
    //Está mal porque por cada item que agregemos hay que modificar este método
    //Pero modularizé tanto que me marié y esto requiere de una solución más compleja (pensé que cada enemigo dropeaba un item y me hacía la vida fácil, pero lo habíamos cambiado para que el usuario elija de los items que existen)
    //Por si te importa el problema específico, lo que se me ocurría al darme cuenta que los enemigos no dropeaban items, era poner un listado de todos los items hasta ahora en un atributo de esta misma clase, y acceder a ella según lo que quiere el usuario (ej si quiere poción de vida o maná, se accede al indice del array de items disponibles y se agrega a su inventario). El problema es que si se agregan 2 pociones de vida, se está agregando la misma poción de vida. Si se usa se usan todas entonces.
    //Para simplemente ignorar todo, hardcodié que cada vez que se toma una decisión, se crea un nuevo objeto del item que eligió.
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

    public static String recompensasDisponibles()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\n==Items Disponibles==\n\n");
        sb.append("1. Pocion de vida.\n");
        sb.append("2. Pocion de maná\n\n");

        return sb.toString();
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

    //Menú para que el usuario elija la clase/personaje que desea usar. Devuelve el personaje elegido.
    public static Jugador menuEleccionClase() //todo: una vez esté hecho el toString en "GestoraEntidadesYaCargadas" lo completo
    {
        System.out.println("\n==PERSONAJES DISPONIBLES==\n\n");
        String clasesDisponibles = GestoraEntidadesYaCargadas.listarPersonajes(clasesAElegir);
        System.out.println(clasesDisponibles);
        System.out.println("\n");

        int cantClases = clasesAElegir.size();

        Jugador jugadorElegido;

        while (true)
        {
            int decision = elegirOpcion();

            if (cantClases <= decision)
            {
                return jugadorElegido = clasesAElegir.get(decision);
            }else
            {
                System.out.println("Por favor elija una de las opciones.\n\n");
            }
        }
    }

    public static int elegirOpcion()
    {
        int decision;

        do {
            System.out.println("\nSeleccione una de las opciones: ");
            try {
                decision = sc.nextInt();
                return decision;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + "Ingrese un valor valido.\n"); //e.get message no te tira el texto gigante?
            } finally {
                sc.nextLine();
            }
        } while (true) ;
    }





}
