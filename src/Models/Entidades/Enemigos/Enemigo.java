package Models.Entidades.Enemigos;

import Models.Entidades.Entidad;

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

    public static int elegirAccion()
    {
        return random.nextInt(2) + 1;
        // 2 siendo el tope y +1 donde comienza, porque si no, comenzaria en 0 y serian nums aleatorios de 0 a 2
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
