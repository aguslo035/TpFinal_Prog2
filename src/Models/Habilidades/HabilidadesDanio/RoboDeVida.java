package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class RoboDeVida extends HabilidadDanio{
    private int curacionRecibida;

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public RoboDeVida(String nombre, String descripcion, int danio, int costoMana, int curacionRecibida) {
        super(nombre, descripcion, danio, costoMana);
        this.curacionRecibida = curacionRecibida;
    }

    public RoboDeVida() {
        super("Robo de Vida", "Hace daño y recupera la misma cantidad de vida.", 5, 10);
        this.curacionRecibida = this.getDanio(); //recupera el daño que hace
    }

    //getters y setters
    public int getCuracionRecibida() {
        return curacionRecibida;
    }

    public void setCuracionRecibida(int curacionRecibida) {
        this.curacionRecibida = curacionRecibida;
    }

    //metodos
    public int alLanzarHabilidad(Entidad usuario, Entidad objetivo)
    {
        objetivo.recibirDanio(getDanio());
        usuario.curar(getCuracionRecibida()); //exception si tiene vida máxima
        return getDanio();
    }

    //toString
    @Override
    public String toString() {
        return super.toString() +
                ", curacionRecibida=" + curacionRecibida +
                '}';
    }
}
