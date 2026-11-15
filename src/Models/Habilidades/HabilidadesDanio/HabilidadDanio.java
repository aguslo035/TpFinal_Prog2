package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;
import Models.GestorDeTextoDeCombate;
import Models.Habilidades.Habilidad;

public abstract class HabilidadDanio extends Habilidad {

    ///Atributo
    private int danio;

    ///Constructor
    public HabilidadDanio(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana);
        this.danio = danio;
    }

    ///getter y setter
    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    //Se llama cuando se ha verificado puede usarse una habilidad. La habilidad realiza su daño sobre el objetivo. Devuelve el daño ocasionado al escudo y/o la vida.
    @Override
    public DanioOcasionado usar(Entidad usuario, Entidad objetivo)
    {
        int danioARealizarDeHabilidad = this.getDanio();

        DanioOcasionado danioRealizado;

        danioRealizado = objetivo.recibirDanio(danioARealizarDeHabilidad);

        return danioRealizado;
    }

    ///Método_

    //Describe en un String lo que hizo la habilidad en el turno y lo devuelve.
    @Override
    public String describirComportamiento(Entidad origen, Entidad destino, DanioOcasionado danio) {
        return GestorDeTextoDeCombate.ataqueHabilidad(origen, destino, getNombre(), danio);
    }


    ///toString
    @Override
    public String toString() {
        return super.toString() +
                ", danio=" + danio +
                '}';
    }


}
