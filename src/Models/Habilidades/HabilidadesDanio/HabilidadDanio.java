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
    //lo que recibe como parametro puede cambiar según la habilidad
    //según como hice las habilidades al menos, para este método algunas reciben 2 parametros, unas reciben 1, otras ninguna
    public int calcularDanio(Entidad usuario) //no creo que haga falta traer al usuario, al menos en mi cabeza tenía a las habilidades como su daño aparte despegado del poder de su entidad
    {
        return getDanio();
    }
}
