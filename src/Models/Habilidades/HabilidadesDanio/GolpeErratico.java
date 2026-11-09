package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class GolpeErratico extends HabilidadDanio {
    private int multiplicadorMaximo;

    public GolpeErratico(String nombre, String descripcion, int danio, int costoMana, int multiplicadorMaximo) {
        super(nombre, descripcion, danio, costoMana);
        this.multiplicadorMaximo = multiplicadorMaximo;
    }
    @Override
    public String toString() {
        return "GolpeErratico{" +
                "multiplicadorMaximo=" + multiplicadorMaximo +
                '}';
    }

    @Override
    public int calcularDanio(Entidad usuario) {
        
    }
}
