package Interface;

import Exception.Juego.IndiceInvalidoException;
import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public interface IHabilidad {

    int usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException;
    String verHabilidades();
}
