package Models.Habilidades.HabilidadesDanio;

public final class FlechaCertera extends HabilidadDanio{
    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public FlechaCertera(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }

    public FlechaCertera(int danio) //o recibe el get.ataque del arquero (que no sé donde invocar habilidades igual todavía), o también podemos hacer que se reciba como parametro un arquero e invoque a su .getAtaque en el input del daño
    {
        super("Flecha Certera", "Duplica el danio de tu flecha.", danio*2, 7);
    }
}
