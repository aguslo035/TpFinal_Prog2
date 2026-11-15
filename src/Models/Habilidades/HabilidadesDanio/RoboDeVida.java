package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;
import Models.GestorDeTextoDeCombate;

public final class RoboDeVida extends HabilidadDanio{

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos

    //Cuando se agregue esta habilidad a los personajes, que solamente se llama "Robo de Vida" exactamente
    //Tuve que hacer lógica en turno jugador usando exactamente ese nombre


    public RoboDeVida(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana, danio);
    }

    //metodos
    @Override
    public DanioOcasionado usar(Entidad usuario, Entidad objetivo)
        throws ManaInsuficienteException
    {
        if(!sePuedeUsar(objetivo))
            throw new ManaInsuficienteException();

        int danioARealizarDeHabilidad = this.getDanio();

        DanioOcasionado danioRealizado = objetivo.recibirDanio(danioARealizarDeHabilidad);
        usuario.curar(danioARealizarDeHabilidad);

        return danioRealizado;
    }

    @Override
    public String describirComportamiento(Entidad origen, Entidad destino, DanioOcasionado danio) {
        return GestorDeTextoDeCombate.ataqueHabilidadConCura(origen, destino, getNombre(), danio);
    }
}
