package Interface;

import Exception.Juego.IndiceInvalidoException;
import Models.Entidades.Entidad;

public interface IHabilidad {

    int usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException;
    String verHabilidades();
}
