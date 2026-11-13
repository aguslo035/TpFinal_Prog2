package Interface;

import Models.Entidades.JugadoresClases.Jugador;

public interface IItem {

    //Todos los items son utilizables y definen su propio comportamiento. Llaman a metodos de jugador. Devuelven la cantidad de un valor que hayan modificado.
    int utilizar(Jugador jugador);
    //le cambié el nombre porque no todo item se va a consumir
    //lo cambié de void a int porque necesito devuelva la cantidad afectada, si es que hubo afectación

    String verEstadisticasItem(); //sería el toString de los items

    //Necesito que cada item construya su propio texto de relleno, sino termino agregando muchos IFs en TurnoJugador
    String describirComportamiento(Jugador usuario, int cantidad);

    //Necesito que cada item me pueda dar su propio nombre
    String getNombre();
}
