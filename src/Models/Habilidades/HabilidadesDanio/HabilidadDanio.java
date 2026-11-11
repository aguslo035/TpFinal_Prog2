package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.Entidades.Entidad;
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
    public int usar(Entidad usuario, Entidad objetivo)
        throws ManaInsuficienteException
    {
        if(!sePuedeUsar(objetivo))
            throw new ManaInsuficienteException();

        int danioARealizarDeHabilidad = this.getDanio();

        objetivo.recibirDanio(danioARealizarDeHabilidad); //ojo con esto, ahora mismo las habilidades ignoran el escudo que tenga el enemigo, porque la lógica de quitar escudo está en .ataque y no .recibirDanio
        return danioARealizarDeHabilidad;
    }
}
