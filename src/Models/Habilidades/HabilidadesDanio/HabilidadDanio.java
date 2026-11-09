package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public abstract class HabilidadDanio extends Habilidad {

    private int danio;
    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)


    public HabilidadDanio(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana);
        this.danio = danio;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int calcularDanio(Entidad usuario) //este es el comportamiento default, PERO no sé si convenga siquiera esté acá porque algunos no necesitan este parametro
    { //esto porque en mi mente el daño que provocan algunas habilidad dependen de la estadística de daño de la habilidad, no del ataque del usuario. Entonces en esos casos el "calcularDanio" no usaría parametros del usuario
        return getDanio(); //^ explicame y/o cambiar en caso de no ser lo que pensabas
    }

}
