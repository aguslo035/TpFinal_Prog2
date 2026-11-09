package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;

public final class Arquero extends Jugador{
    private double probabilidadCritica;

    public Arquero(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa, TipoArma tipoArma, double probabilidadCritica) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa, tipoArma);
        this.probabilidadCritica = probabilidadCritica;
    }

    public double getProbabilidadCritica() {
        return probabilidadCritica;
    }

    public void setProbabilidadCritica(double probabilidadCritica) {
        this.probabilidadCritica = probabilidadCritica;
    }

    @Override
    public String toString() {
        return "Arquero{" + super.toString() +
                ", probabilidadCritica=" + probabilidadCritica +
                '}';
    }
}
