package Models.Habilidades.HabilidadesDanio;

public final class RoboDeVida extends HabilidadDanio{
    private int curacionRecibida;

    public RoboDeVida(String nombre, String descripcion, int danio, int costoMana, int curacionRecibida) {
        super(nombre, descripcion, danio, costoMana);
        this.curacionRecibida = curacionRecibida;
    }
}
