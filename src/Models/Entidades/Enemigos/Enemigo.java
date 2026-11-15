package Models.Entidades.Enemigos;

import Enumerator.EAccionEnemigo;
import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

//Es la clase rival del jugador. Su función es matarlo.
public abstract class Enemigo extends Entidad {

    ///atributos
    private static int idAux = 0; //esto se guarda en la misma base de datos de enemigos?
    private final int id;
    private static final Random random = new Random();
    // static porque pertenece a la clase, no a sus instancias. Y final porque quiero q no haya nuevos new Random()

    ///constructores
    public Enemigo(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        id = idAux;
        idAux++;
    }

    public Enemigo(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.id = id;
    } // para traer enemigos de la base de datos que ya tienen una id y no utilicen el idAux, ya que seria incorrecto y seria el mismo enemigo con otra id cada vez que se trae de la base de datos.

    ///getter de ID
    public int getId() {
        return id;
    }

    ///Métodos

    //Devuelve una acción posible que esté en EAccionEnemigo.
    public EAccionEnemigo elegirAccion() //no es static porque si un enemigo quiere comportarse distinto, no pueden sobre-escribir el método
    {
        EAccionEnemigo[] accionesPosibles = EAccionEnemigo.values(); //Crea un array fijo con las acciones posibles en EAccionEnemiga. .values() de un enum devuelve un array con las opciones del enum.
        int cantAcciones = accionesPosibles.length; //el limite de acciones lo pone la cantidad de opciones en el Enum

        EAccionEnemigo decisionTomada;

        if(puedeUsarHabilidades()){ //si puede utilizar habilidades, el enemigo puede decidir si usa una habilidad. Si no puede, decide atacar siempre.
            decisionTomada = accionesPosibles[random.nextInt(cantAcciones)];
        }else {
            decisionTomada = EAccionEnemigo.ATACAR;
        }

        return decisionTomada;
    }

    //Devuelve un listado con las habilidades para las cuales se tiene maná para usar. Es llamado cuando quiere confirmarse si el enemigo pueden usar habilidades, y a la hora de querer usar una para saber qué opciones hay.
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

    //Devuelve true si hay maná suficiente para usar al menos una habilidad. False en caso contrario.
    public boolean puedeUsarHabilidades ()
    {
        List<Habilidad> habilidadesPosibles = getHabilidadesDisponibles();

        return !habilidadesPosibles.isEmpty();
    }

    //De las habilidades para las cuales el enemigo tiene suficiente maná para usar, devuelve una de ellas aleatoriamente. Si no hay habilidades, devuelve null.
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

    ///Equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Enemigo enemigo)) return false;
        return id == enemigo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    ///toString

    @Override
    public String toString() {
        return "Enemigo{"+
                "id=" + id +
                ", "+ super.toString() +
                ", Habilidades: " + this.verHabilidades() +
                '}';
    }
}
