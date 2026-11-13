package Models.Entidades.Enemigos;

import Enumerator.EAccionEnemigo;
import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public abstract class Enemigo extends Entidad {
    private static int idAux = 0; //esto se guarda en la misma base de datos de enemigos?
    private final int id;
    private static final Random random = new Random(); // Random es una clase de java
    // static porque pertenece a la clase, no a sus instancias. Y final porque quiero q no haya nuevos new Random()
    public Enemigo(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        id = idAux;
        idAux++;
    }

    public Enemigo(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.id = id;
    } // para traer enemigos de la base de datos que ya tienen una id y no utilicen el idAux, ya que seria incorrecto y seria el mismo enemigo con otra id cada vez que se trae de la base de datos.

    public int getId() {
        return id;
    }

    //quiero probarlo hacerlo con Enum
    //también puede contemplar futuras acciones que agregemos
    //le saco el static porque puede ser que algún día decidamos un enemigo se comporte distinto, y si es static no se puede sobre-escribir
    public EAccionEnemigo elegirAccion()
    {
        EAccionEnemigo[] accionesPosibles = EAccionEnemigo.values(); //.values() de un enum devuelve un array fijo con las opciones en EAccionEnemigo
        int cantAcciones = accionesPosibles.length; //por si algún día agregamos más acciones que puede tomar el enemigo, el limite lo pone la cantidad de opciones en el Enum

        EAccionEnemigo decisionTomada;

        if(puedeUsarHabilidades()){ //si ya no puede usar habilidades solo ataca, caso contrario puede hacer otras cosas que estén en el ENUM
            decisionTomada = accionesPosibles[random.nextInt(cantAcciones)];
        }else {
            decisionTomada = EAccionEnemigo.ATACAR;
        }

        return decisionTomada;

        // 2 siendo el tope y +1 donde comienza, porque si no, comenzaria en 0 y serian nums aleatorios de 0 a 2
        //^como ahora tengo un array que empieza en 0 voy a sacar el +1.
    }

    //lo que voy a hacer, es que cada vez que va a tomar una decisión, el enemigo revise qué habilidades pueda usar (usando maná actual) y las devuelva en un listado.
    //después si decide usar una habilidad, decide aleatoriamente qué habilidad usa
    public ArrayList<Habilidad> getHabilidadesDisponibles()
    {
        ArrayList<Habilidad> habilidadesPuedeUsar = new ArrayList<>();

        for (Habilidad aux : this.getHabilidades())
        {
            if(aux.getCostoMana() <= this.getManaActual())
            {
                habilidadesPuedeUsar.add(aux);
            }
        }

        return habilidadesPuedeUsar;
    }

    public boolean puedeUsarHabilidades ()
    {
        List<Habilidad> habilidadesPosibles = getHabilidadesDisponibles();

        return !habilidadesPosibles.isEmpty();
    }

    //Dentro recibe un array con las habilidades para las cuales el enemigo tiene maná suficiente. Devuelve una de estas. Si no hay habilidades, devuelve null.
    public Habilidad elegirHabilidadAUsar()
    {
        List<Habilidad> habilidadesPosibles = getHabilidadesDisponibles();

        int cantHabilidadesDisponibles = habilidadesPosibles.size();

        if (cantHabilidadesDisponibles == 0)
        {
            return null;
        }else
        {
            return habilidadesPosibles.get(random.nextInt(cantHabilidadesDisponibles));
        }

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Enemigo enemigo)) return false;
        return id == enemigo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
