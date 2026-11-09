package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class BolaDeFuego extends HabilidadDanio{

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public BolaDeFuego(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }

    public BolaDeFuego()
    {
        super("Bola de Fuego", "Lanza una bola de llamas.", 10, 10);
    }

    //metodos
    @Override
    public int usar(Entidad usuario, Entidad objetivo) {

        int danioARealizarDeHabilidad = this.getDanio();

        objetivo.recibirDanio(danioARealizarDeHabilidad);
        return danioARealizarDeHabilidad;
    }
}
