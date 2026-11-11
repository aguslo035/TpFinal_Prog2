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

    //getters y setters
    public int getCuracionRecibida() {
        return curacionRecibida;
    }

    public void setCuracionRecibida(int curacionRecibida) {
        this.curacionRecibida = curacionRecibida;
    }

    //metodos
    @Override
    public int usar(Entidad usuario, Entidad objetivo) {
        int danioARealizarDeHabilidad = this.getDanio();

        objetivo.recibirDanio(danioARealizarDeHabilidad);
        usuario.curar(danioARealizarDeHabilidad);

        return danioARealizarDeHabilidad;
    }

    //toString

    @Override
    public String toString() {
        return "RoboDeVida{" +
                "curacionRecibida=" + curacionRecibida +
                '}';
    }
}
