package Interface;

import Models.Entidades.JugadoresClases.Jugador;

public interface IItem {

    //Todos los items son utilizables y definen su propio comportamiento. Llaman a metodos de jugador. Devuelven la cantidad de un valor que hayan modificado.
    int utilizar(Jugador jugador);

    //Funciona como un toString de los items
    String verEstadisticasItem();

    //Cada item construye su propio texto de relleno para mostrarle al jugador lo que se realizó.
    String describirComportamiento(Jugador usuario, int cantidad);

    //Cada item debe sí o sí poder entregar su propio nombre.
    String getNombre();
}
