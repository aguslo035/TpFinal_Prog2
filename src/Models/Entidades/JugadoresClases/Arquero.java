package Models.Entidades.JugadoresClases;

import Enumerator.TipoArma;
import Models.DanioOcasionado;
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
        this.agregarHabilidad(new FlechaCertera("Flecha certera", "una flecha directa al punto débil", this.getManaMaximo() / 4, this.getAtaque(), 2));
    }

    public Arquero(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma, double probabilidadCritica) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, tipoArma);
        this.probabilidadCritica = probabilidadCritica;
        this.agregarHabilidad(new FlechaCertera("Flecha certera", "una flecha directa al punto débil", this.getManaMaximo() / 4, this.getAtaque(), 2));
    }

    public double getProbabilidadCritica() {
        return probabilidadCritica;
    }

    public void setProbabilidadCritica(double probabilidadCritica) {
        this.probabilidadCritica = probabilidadCritica;
    }

    @Override
    public DanioOcasionado atacar(Entidad objetivo) {
        int danioARealizar = getAtaque();
        if (random.nextDouble() < probabilidadCritica) {
            danioARealizar = danioARealizar * 2; //es un golpe crítico
        }

        DanioOcasionado danioRealizado = objetivo.recibirDanio(danioARealizar);

        return danioRealizado;
    }

    @Override
    public String toString() {
        return "Arquero{" + super.toString() +
                ", probabilidadCritica=" + probabilidadCritica +
                '}';
    }
}
