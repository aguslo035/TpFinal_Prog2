package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.Entidades.Entidad;

public final class RoboDeVida extends HabilidadDanio{

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)

    public RoboDeVida(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana, danio);
    }

    //metodos
    @Override
    public int usar(Entidad usuario, Entidad objetivo)
        throws ManaInsuficienteException
    {
        if(!sePuedeUsar(objetivo))
            throw new ManaInsuficienteException();

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
