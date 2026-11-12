package Controller;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//eventualmente le quiero agregar el MenuAdmin
public abstract class MenuInicial {

    private static List<Jugador> clasesAElegir = new ArrayList<>();
    private static List<Enemigo> enemigos = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void inicioJuego()
    {
        clasesAElegir = GestoraEntidadesYaCargadas.jugadores();
        enemigos = GestoraEntidadesYaCargadas.enemigos();

        int opcion;
        Jugador jugadorElegido;
        boolean continuar = false;

        while(!continuar)
        {
            System.out.println(menuOpciones());

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion)
            {
                case 1:
                    jugadorElegido =
                            BatallaPorTurnos()
            }
        }





        sc.close();
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
    }

    public static Jugador menuEleccionClase()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(clasesAElegir.);
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
                System.out.println(e.getMessage() + "Ingrese un valor valido.");
            } finally {
                sc.nextLine();
            }
        } while (true) ;
    }





}
