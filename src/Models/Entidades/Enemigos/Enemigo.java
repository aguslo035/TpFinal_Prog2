package Models.Entidades.Enemigos;

import Models.Entidades.Entidad;

import java.util.Objects;

public abstract class Enemigo extends Entidad {
    private static int idAux = 0;
    private final int id;

    public Enemigo(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa);
        id = idAux;
        idAux++;
    }

    public int getId() {
        return id;
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
