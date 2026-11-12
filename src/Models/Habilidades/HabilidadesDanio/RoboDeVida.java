package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
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

    @Override
    public String describirComportamiento(Entidad origen, Entidad destino, int danio) {
        return GestorDeTextoDeCombate.ataqueHabilidadConCura(origen, destino, getNombre(), danio, danio); //tengo que asumir se cura lo mismo que daña, a menos que hagamos una cura fija en variable
    }

    //toString
    @Override
    public String toString() {
        return "RoboDeVida{" +
                "curacionRecibida=" + curacionRecibida + //todo: arreglar el toString de esto
                '}';
    }
}
