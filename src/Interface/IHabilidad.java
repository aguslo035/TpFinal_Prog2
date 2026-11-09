package Interface;

import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public interface IHabilidad {

    int usarHabilidad(int indice, Entidad objetivo);
    String verHabilidades();
}
