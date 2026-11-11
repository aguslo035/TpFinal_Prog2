package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.Entidades.Entidad;

public final class FlechaCertera extends HabilidadDanio{
    private int multiplicadorCritico;

    public FlechaCertera(String nombre, String descripcion, int costoMana, int danio, int multiplicadorCritico) {
        super(nombre, descripcion, costoMana, danio);
        this.multiplicadorCritico = multiplicadorCritico;
    }

    //metodos
    @Override
    public int usar(Entidad usuario, Entidad objetivo)
        throws ManaInsuficienteException
        {
            if(!sePuedeUsar(objetivo))
                throw new ManaInsuficienteException();
        int probCritica = multiplicadorCritico;
        int danioARealizarDeHabilidad = this.getDanio() * probCritica;

        objetivo.recibirDanio(danioARealizarDeHabilidad);
        return danioARealizarDeHabilidad;
    }

}
