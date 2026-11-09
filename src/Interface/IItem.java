package Interface;

import Models.Entidades.JugadoresClases.Jugador;

public interface IItem {

    void consumir(Jugador jugador); //cada item va a definir su propio comportamiento, llama a metodos de jugador

    String verEstadisticasItem(); //sería el toString de los items
}
