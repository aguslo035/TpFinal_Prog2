package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;

public final class Guerrero extends Jugador{
    public Guerrero(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
    }

    public Guerrero(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
    }

    //sin esto al llamar al toString va a imprimir "jugador" en vez de "guerrero"
    @Override
    public String toString() {
        return "Guerrero{"+ super.toString();
    }
}
