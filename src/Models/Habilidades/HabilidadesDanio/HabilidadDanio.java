package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public abstract class HabilidadDanio extends Habilidad {

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public HabilidadDanio(String nombre, String descripcion, int danio, int costoMana) {
        super(nombre, descripcion, danio, costoMana);
    }

    public int calcularDanio(Entidad usuario) //este es el comportamiento default, PERO no sé si convenga siquiera esté acá porque algunos no necesitan este parametro
    { //esto porque en mi mente el daño que provocan algunas habilidad dependen de la estadística de daño de la habilidad, no del ataque del usuario. Entonces en esos casos el "calcularDanio" no usaría parametros del usuario
        return getDanio(); //^ explicame y/o cambiar en caso de no ser lo que pensabas
    }

    public abstract int alLanzarHabilidad (Entidad usuario, Entidad objetivo); //cada habilidad decide qué consecuencias produce, devuevle daño
    //lo pongo abstracto para obligar a que se use
    //no todas las habilidades necesitan al usuario para cálculos:
    //lo pongo para que todas las clases tengan un mismo metodo que venga de una clase padre (temporal)
    //y para potencialmente eventualmente devolver texto de relleno (el "(nombre) dispara una flecha certera a (nombre), haciendo (danio) daño!")
    //que es lógica puede terminemos no poniendo acá
}
