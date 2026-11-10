package Interface;

import Models.Entidades.JugadoresClases.Jugador;

public interface IItem {

    void utilizar(Jugador jugador); //cada item va a definir su propio comportamiento, llama a metodos de jugador
    //le cambié el nombre porque no todo item se va a consumir

    String verEstadisticasItem(); //sería el toString de los items
}
