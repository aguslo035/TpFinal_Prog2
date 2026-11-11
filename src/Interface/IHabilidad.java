package Interface;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.Entidades.Entidad;

public interface IHabilidad {

    int usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException, ManaInsuficienteException;
    String verHabilidades();
}
