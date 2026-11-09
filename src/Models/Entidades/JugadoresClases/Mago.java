package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;

public final class Mago extends Jugador{
    public Mago(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa, tipoArma);
    }

    //toString

    @Override
    public String toString() {
        return "Mago{"+ super.toString()+ "}";
    }
}
