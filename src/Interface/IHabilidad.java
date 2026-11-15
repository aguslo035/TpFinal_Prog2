package Interface;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;

// Se aplica a toda entidad o cosa que pueda utilizar habilidades.
public interface IHabilidad {

    //Toda entidad o cosa que pueda utilizar habilidades, debe poder utilizar la habilidad.
    //Devuelve el daño ocasionado como consecuencia de utilizarla.
    DanioOcasionado usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException, ManaInsuficienteException;

    //Para cualquier ser capaz de utilizar habilidades, se debe de poder ver en un listado sus habilidades.
    String verHabilidades();

}
