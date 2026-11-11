package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class GolpeErratico extends HabilidadDanio {
    private int danioFijo;

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)


    public GolpeErratico(String nombre, String descripcion, int costoMana, int danio, int danioFijo) {
        super(nombre, descripcion, costoMana, danio);
        this.danioFijo = danioFijo;
    }

    //getters y setters
    public int getDanioFijo() {
        return danioFijo;
    }

    public void setDanioFijo(int danioFijo) {
        this.danioFijo = danioFijo;
    }

    //metodos
    @Override
    public int usar(Entidad usuario, Entidad objetivo) {
        int danioARealizarDeHabilidad = this.getDanio() + danioFijo;
        // pensando que es para algun guerrero o caballero, se le suma el danio del personaje + (el danio de la habilidad y el extra del golpe erratico)
        // ^^ no entiendo la primera variable ni dónde se agregaría el daño del usuario

        objetivo.recibirDanio(danioARealizarDeHabilidad);
        return danioARealizarDeHabilidad;
    }

    //toString reformateado (no llamo al super) por el tema de que el daño es 0
    @Override
    public String toString() {
        return "Habilidad: " +
                "nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", costoMana=" + getCostoMana() +
                ", danioFijo=" + getDanioFijo();
    }

}
