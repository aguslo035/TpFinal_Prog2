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

    //no es necesario poner este metodo en esta clase porque la hereda default del padre y ni se usa, pero lo escribo para mostrar que hay re-ver cómo está el método en la clase padre
    //también está el tema de que pide un parametro que no se usa (al igual que mi parametro de usuario arriba de este metodo)
    public int calcularDanio(Entidad usuario)
    {
        return getDanio();
    }
}
