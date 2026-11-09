package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;

public final class Guerrero extends Jugador{
    public Guerrero(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa, tipoArma);
    }
}
