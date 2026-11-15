package Models.Habilidades.HabilidadesDanio;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;
import Models.GestorDeTextoDeCombate;

public final class FlechaCertera extends HabilidadDanio{

    ///atributos
    private int multiplicadorCritico;

    ///constructor
    public FlechaCertera(String nombre, String descripcion, int costoMana, int danio, int multiplicadorCritico) {
        super(nombre, descripcion, costoMana, danio);
        this.multiplicadorCritico = multiplicadorCritico;
    }

    ///metodos

    //Por el valor crítico de la habilidad, esta ocasiona más daño que el que se ve en su atributo. Devuelve el daño ocasionado al escudo y/o a la vida
    @Override
    public DanioOcasionado usar(Entidad usuario, Entidad objetivo)
    {
        int probCritica = multiplicadorCritico;
        int danioARealizarDeHabilidad = this.getDanio() * probCritica;

        DanioOcasionado danioRealizado = objetivo.recibirDanio(danioARealizarDeHabilidad);

        return danioRealizado;
    }



}
