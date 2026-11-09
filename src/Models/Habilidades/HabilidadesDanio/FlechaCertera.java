package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;

public final class FlechaCertera extends HabilidadDanio{
    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public FlechaCertera(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }

    public FlechaCertera(Entidad usuarioPoseedor) //o recibe un int con el ataque del arquero (que no sé donde invocar habilidades igual todavía), o también como está ahora que recibe como parametro un arquero e invoque a su .getAtaque para el daño
    {
        super("Flecha Certera", "Duplica el daño de tu flecha.", usuarioPoseedor.getAtaque()*2, 10);
    }

    //metodos
    public void alLanzarHabilidad (Entidad usuario, Entidad objetivo)
    {
        objetivo.recibirDanio(getDanio());
    }

    //no es necesario poner este metodo en esta clase porque la hereda default del padre y ni se usa, pero lo escribo para mostrar que tal vez o reeplantear como es esta habilidad, o reconsiderar este metodo en "habilidad danio"
    //también está el tema de que pide un parametro que no se usa (al igual que mi parametro de usuario arriba de este metodo)
    public int calcularDanio(Entidad usuario)
    {
        return getDanio();
    }
}
