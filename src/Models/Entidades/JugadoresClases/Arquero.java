package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;
import Models.Entidades.Entidad;

import java.util.Random;

public final class Arquero extends Jugador{
    private double probabilidadCritica; // debe ser con probabilidad, de 0 hasta 1
    private static final Random random = new Random();
    // lo mismo que en enemigo con el numero random, se usara nextDouble() que es un numero random entre 0 y 1

    public Arquero(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa, tipoArma);
        this.probabilidadCritica = 0.35;
    }

    public double getProbabilidadCritica() {
        return probabilidadCritica;
    }

    public void setProbabilidadCritica(double probabilidadCritica) {
        this.probabilidadCritica = probabilidadCritica;
    }

    @Override
    public int atacar(Entidad objetivo) {
        int danioARealizar = getAtaque();
        if (random.nextDouble() < probabilidadCritica) {
            danioARealizar = danioARealizar * 2; //es un golpe crítico
        }

        // danio con critico
        danioARealizar = danioARealizar - objetivo.getDefensa();
        if (danioARealizar < 0) {
            objetivo.setDefensa(danioARealizar * (-1));
            return 0;
        }
        objetivo.recibirDanio(danioARealizar);
        objetivo.setDefensa(0);
        return danioARealizar;
        //la logica es la misma que atacar de todos despues de lo del critico
    }

    @Override
    public String toString() {
        return "Arquero{" + super.toString() +
                ", probabilidadCritica=" + probabilidadCritica +
                '}';
    }
}
