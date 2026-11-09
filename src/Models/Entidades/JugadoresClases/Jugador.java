package Models.Entidades.JugadoresClases;

import Controller.GestoraDeItems;
import Enumerator.TipoArma;
import Models.Entidades.Entidad;

import java.util.Objects;

public abstract class Jugador extends Entidad {
    private static int idAux = 0;
    private final int id;
    private final TipoArma tipoArma;
    private GestoraDeItems inventario;

    public Jugador(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa);
        this.tipoArma = tipoArma;
        id = idAux;
        idAux++;

        inventario = new GestoraDeItems();
    }

    public int getId() {
        return id;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;
        return id == jugador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", tipoArma=" + tipoArma +
                ", inventario=" + inventario +
                '}';
    }

    public void usarItem(int indice)
    {

    }
}
