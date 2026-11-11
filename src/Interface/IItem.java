package Interface;

import Models.Entidades.JugadoresClases.Jugador;

public interface IItem {

    //Todos los items son utilizables y definen su propio comportamiento. Llaman a metodos de jugador. Devuelven la cantidad de un valor que hayan modificado.
    int utilizar(Jugador jugador);
    //le cambié el nombre porque no todo item se va a consumir
    //lo cambié de void a int porque necesito devuelva la cantidad afectada, si es que hubo afectación

    String verEstadisticasItem(); //sería el toString de los items
}
