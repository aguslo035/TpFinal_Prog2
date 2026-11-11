package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class BolaDeFuego extends HabilidadDanio{

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public BolaDeFuego(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }
}
