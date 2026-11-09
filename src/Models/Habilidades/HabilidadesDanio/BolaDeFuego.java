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
    public int alLanzarHabilidad(Entidad usuario, Entidad objetivo) //es lo que ocurre al lanzar la habilidad
    {
        objetivo.recibirDanio(calcularDanio(usuario)); //le mando el usuario pero no hago nada con él
        return calcularDanio(usuario);
    }

    @Override
    public int calcularDanio(Entidad usuario) { //el usuario no se usa para calcular el daño
        return getDanio();
    }

    @Override
    public int usar(Entidad usuario, Entidad objetivo) {

        int danioARealizarDeHabilidad = this.getDanio();

        objetivo.recibirDanio(danioARealizarDeHabilidad);
        return danioARealizarDeHabilidad;
    }
}
