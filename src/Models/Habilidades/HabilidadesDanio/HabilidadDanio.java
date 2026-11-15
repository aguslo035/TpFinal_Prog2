package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;
import Models.GestorDeTextoDeCombate;
import Models.Habilidades.Habilidad;

public abstract class HabilidadDanio extends Habilidad {

    private int danio;
    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)


    public HabilidadDanio(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana);
        this.danio = danio;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    @Override
    public DanioOcasionado usar(Entidad usuario, Entidad objetivo) throws ManaInsuficienteException
    {
        if(!sePuedeUsar(objetivo))
            throw new ManaInsuficienteException();

        int danioARealizarDeHabilidad = this.getDanio();

        DanioOcasionado danioRealizado;

        danioRealizado = objetivo.recibirDanio(danioARealizarDeHabilidad);

        return danioRealizado;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", danio=" + danio +
                '}';
    }

    @Override
    public String describirComportamiento(Entidad origen, Entidad destino, DanioOcasionado danio) {
        return GestorDeTextoDeCombate.ataqueHabilidad(origen, destino, getNombre(), danio);
    }
}
