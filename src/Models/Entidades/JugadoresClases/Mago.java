package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;

public final class Mago extends Jugador{
    public Mago(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
    }

    public Mago(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
    }

    //toString

    @Override
    public String toString() {
        return "Mago{"+ super.toString()+ "}";
    }
}
