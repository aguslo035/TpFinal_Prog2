package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public abstract class HabilidadDanio extends Habilidad {
    public HabilidadDanio(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }

    public int calcularDanio(Entidad usuario)
    {

    }
}
