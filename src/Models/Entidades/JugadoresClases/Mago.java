package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;
import Models.Habilidades.HabilidadesDanio.BolaDeFuego;

public final class Mago extends Jugador{
    public Mago(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
        this.agregarHabilidad(new BolaDeFuego("Bola de fuego", "op", this.getManaMaximo() / 3, this.getAtaque() * 3));
    }

    public Mago(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
        this.agregarHabilidad(new BolaDeFuego("Bola de fuego", "op", this.getManaMaximo() / 3, this.getAtaque() * 3));
    }

    //toString

    @Override
    public String toString() {
        return "Mago{"+ super.toString()+ "}";
    }
}
