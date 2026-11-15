package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;
import Models.GestorDeTextoDeCombate;

public final class RoboDeVida extends HabilidadDanio{

    ///Constructor
    public RoboDeVida(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana, danio);
    }

    ///metodos

    //Se llama cuando se ha verificado puede usarse una habilidad. Devuelve el daño ocasionado al escudo y/o la vida.
    @Override
    public DanioOcasionado usar(Entidad usuario, Entidad objetivo)
    {
        int danioARealizarDeHabilidad = this.getDanio();

        DanioOcasionado danioRealizado = objetivo.recibirDanio(danioARealizarDeHabilidad);
        usuario.curar(danioARealizarDeHabilidad); //esta habilidad cura al usuario la misma cantidad que el daño que hizo

        return danioRealizado;
    }

    //Describe en un String lo que realizó la habilidad en una ronda y lo devuelve.
    @Override
    public String describirComportamiento(Entidad origen, Entidad destino, DanioOcasionado danio) {
        return GestorDeTextoDeCombate.ataqueHabilidadConCura(origen, destino, getNombre(), danio);
    }
}
