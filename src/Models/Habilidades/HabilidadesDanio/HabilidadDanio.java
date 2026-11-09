package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public abstract class HabilidadDanio extends Habilidad {

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public HabilidadDanio(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }

    //puede resultar útil que esto no esté acá, y/o cambiarle el nombre ("ejecutarHabilidad" tal vez que haga lo requerido)
    //el tema es que lo que recibe como parametro puede cambiar según la habilidad
    //al menos por como hice las habilidades, de método algunas reciben 2 parametros, unas reciben 1, otras ninguna
    public int calcularDanio(Entidad usuario)
    {
        return getDanio();
    }
}
