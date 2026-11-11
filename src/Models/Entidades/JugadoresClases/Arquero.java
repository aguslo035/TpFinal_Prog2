package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;
import Models.Entidades.Entidad;
import Models.Habilidades.HabilidadesDanio.FlechaCertera;

import java.util.Random;

public final class Arquero extends Jugador{
    private double probabilidadCritica; // debe ser con probabilidad, de 0 hasta 1
    private static final Random random = new Random();
    // lo mismo que en enemigo con el numero random, se usara nextDouble() que es un numero random entre 0 y 1

    public Arquero(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma, double probabilidadCritica) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
        this.probabilidadCritica = probabilidadCritica;

    }

    public Arquero(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma, double probabilidadCritica) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
        this.probabilidadCritica = probabilidadCritica;
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
        danioARealizar = danioARealizar - objetivo.getEscudo();
        if (danioARealizar < 0) {
            objetivo.setEscudo(danioARealizar * (-1));
            return 0;
        }
        objetivo.recibirDanio(danioARealizar);
        objetivo.setEscudo(0);
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
