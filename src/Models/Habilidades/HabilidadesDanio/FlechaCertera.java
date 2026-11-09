package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class FlechaCertera extends HabilidadDanio{
    private int multiplicadorCritico;

    public FlechaCertera(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana, danio);
        multiplicadorCritico = 2;
    }
    //metodos
    @Override
    public int usar(Entidad usuario, Entidad objetivo) {

        int probCritica = multiplicadorCritico;
        int danioARealizarDeHabilidad = this.getDanio() * probCritica;

        objetivo.recibirDanio(danioARealizarDeHabilidad);
        return danioARealizarDeHabilidad;
    }

}
