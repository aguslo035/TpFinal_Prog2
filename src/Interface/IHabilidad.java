package Interface;

import Models.Entidades.Entidad;

public interface IHabilidad {

    int usarHabilidad(int indice, Entidad objetivo);
    String verHabilidades();
    boolean puedeUsarse(Entidad usuario); //comentario sobre esto en la implementación en Entidad
}
