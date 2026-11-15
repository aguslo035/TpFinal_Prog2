package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;
import Models.GestorDeTextoDeCombate;

public final class FlechaCertera extends HabilidadDanio{
    private int multiplicadorCritico;

    public FlechaCertera(String nombre, String descripcion, int costoMana, int danio, int multiplicadorCritico) {
        super(nombre, descripcion, costoMana, danio);
        this.multiplicadorCritico = multiplicadorCritico;
    }

    //metodos
    @Override
    public DanioOcasionado usar(Entidad usuario, Entidad objetivo)
    {
        int probCritica = multiplicadorCritico;
        int danioARealizarDeHabilidad = this.getDanio() * probCritica;

        DanioOcasionado danioRealizado = objetivo.recibirDanio(danioARealizarDeHabilidad);

        return danioRealizado;
    }



}
