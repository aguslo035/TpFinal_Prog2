package Controller;

import Models.ConstructorDeTextoParaTurnos.GestorDeTextoDeCombate;
import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.JugadoresClases.Jugador;

import java.util.Scanner;

public class TurnoJugador {

    //scanner
    Scanner sc; //Nota: inicializarlo acá

    //constructor
    public TurnoJugador() {
        sc = new Scanner(System.in);
    }

    //métodos

    //Muestra las opciones que tiene el jugador en su turno. Realiza acciones de acorde a su decisión. Devuelve texto de a corde a la acción realizada.
    public String menuAtaque(Jugador jugador, Enemigo enemigo) //este metodo lo llaman en el turno usuario, así que ya se sabe qué entidad es cada uno (por eso especifico Jugador y Enemigo)
    {
        boolean continuar = false; //cambia al tomar acción que finalize el turno
        int decision = 0;
        int aux; //recibe un número para mostrar después (ej, daño ocasionado, cuánto se curó, etc)
        String accionRealizada;

        System.out.println(estadoPelea(jugador, enemigo)); //Muestra HP/MP/Escudo restante de los 2

        System.out.println(mostrarOpcionesCombate()); //le da a elegir al usuario

        while (!continuar)
        {
            decision = elegirOpcion();

            switch (decision)
            {
                case 0:
                    aux = jugador.atacar(enemigo);
                    continuar = true;
                    accionRealizada = GestorDeTextoDeCombate.ataque(jugador, enemigo, aux);
                    break;
                case 1:
                    accionRealizada = menuHabilidad(jugador, enemigo);
                    break;
                case 2:

                    //llama a un metodo de menu de items
                case 3:



            }
        }


        return accionRealizada;
        //va a terminar devolviendo un flavor text: "X ataca a Y por 123 de daño!"
    }

    //Se listan todas las habilidades + opción de volver al menú de ataque. Una vez el usuario decide correctamente, devuelve un String indicando la elección realizada (que se realizó el ataque o se volvió al menú).
    public String menuHabilidad(Jugador jugador, Enemigo enemigo)
    {
        boolean continuar = false;
        int decision = 0;

        String accionRealizada;

        do {
            System.out.println("===Habilidades disponibles===\n\n");
            System.out.println(jugador.verHabilidades());
            int i = jugador.contarHabilidades();
            System.out.println("#"+i+" - Volver a Opciones");

            decision = elegirOpcion();

            if (decision == i)
            {
                accionRealizada = "VOLVER";
                continuar = true;
            }else
            {
                //TRY CATCH ACÁ ("habilidadNoExisteException") -> si intenta elegir del arraylist un indice que no existe (hay que agregar el throws exception en .usarHabilidad)
                try {
                    int danioCausado = jugador.usarHabilidad(decision, enemigo); //esto lanza "HabilidadNoExisteException"
                    //lo siguiente solo ocurre si no ocurrió una exception (elige opción valida)
                    accionRealizada = GestorDeTextoDeCombate.ataqueHabilidad(jugador, enemigo, jugador.getHabilidades().get(decision).getNombre(), danioCausado);
                    continuar = true;
                } catch (HabilidadNoExisteException e) {
                    System.out.println("Eliga una opción valida de las mostradas.");
                }
            }

        }while (!continuar);

        return accionRealizada;
    }

    public String menuItems(Jugador jugador, Enemigo enemigo)
    {
        boolean continuar = false;
        int decision = 0;

        String accionRealizada;

        do {
            System.out.println("===Items disponibles===\n\n");
            System.out.println(jugador.obtenerInventario());
            int i = jugador.contarItemsInventario();
            System.out.println("#"+i+" - Volver a Opciones");

            decision = elegirOpcion();

            if (decision == i)
            {
                accionRealizada = "VOLVER";
                continuar = true;
            }else
            {
                //TRY CATCH ACÁ ("habilidadNoExisteException") -> si intenta elegir del arraylist un indice que no existe (hay que agregar el throws exception en .usarHabilidad)
                try {
                    int danioCausado = jugador.usarHabilidad(decision, enemigo); //esto lanza "HabilidadNoExisteException"
                    //lo siguiente solo ocurre si no ocurrió una exception (elige opción valida)
                    accionRealizada = GestorDeTextoDeCombate.ataqueHabilidad(jugador, enemigo, jugador.getHabilidades().get(decision).getNombre(), danioCausado);
                    continuar = true;
                } catch (HabilidadNoExisteException e) {
                    System.out.println("Eliga una opción valida de las mostradas.");
                }
            }

        }while (!continuar);

        return accionRealizada;
    }



    public int elegirOpcion() //el "seleccione una de las opciones muy probablemente sea algo recurrente", lo modularizo
    {
        int decision = 0;

        System.out.println("Seleccione una de las opciones: ");

        sc.nextInt(decision);
        sc.nextLine();

        return decision;
    }


    //este conviene esté en BatallaPorTurnos
    public String estadoPelea(Jugador jugador, Enemigo enemigo) //muestra la vida, MP y efectos actuales de ambos
    {
        StringBuilder sb = new StringBuilder();
        sb.append("===")
                .append(GestorDeTextoDeCombate.mostrarEstado(jugador))
                .append("===")
                .append(GestorDeTextoDeCombate.mostrarEstado(enemigo))
                .append("\n\n");
        return sb.toString();
    }

    public String mostrarOpcionesCombate()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("==OPCIONES==\n\n")
                .append("0. Atacar.\n")
                .append("1. Habilidades.\n")
                .append("2. Inventario\n")
                .append("3. Inspeccionar Enemigo.\n");

        return sb.toString();
    }



}
