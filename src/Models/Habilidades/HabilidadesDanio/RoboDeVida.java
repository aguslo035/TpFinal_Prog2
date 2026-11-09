package Models.Habilidades.HabilidadesDanio;

public final class RoboDeVida extends HabilidadDanio{
    private int curacionRecibida;

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public RoboDeVida(String nombre, String descripcion, int danio, int costoMana, int curacionRecibida) {
        super(nombre, descripcion, danio, costoMana);
        this.curacionRecibida = curacionRecibida;
    }
}
