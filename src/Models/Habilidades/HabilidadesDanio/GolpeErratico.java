package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class GolpeErratico extends HabilidadDanio {
    private int multiplicadorMaximo;

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
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
