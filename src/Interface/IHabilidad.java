package Interface;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;

public interface IHabilidad {

    DanioOcasionado usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException, ManaInsuficienteException;
    String verHabilidades();
}
