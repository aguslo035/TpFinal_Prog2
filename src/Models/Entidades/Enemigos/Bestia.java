package Models.Entidades.Enemigos;

import Models.Habilidades.HabilidadesDanio.Mordida;

public final class Bestia extends Enemigo{
    public Bestia(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.agregarHabilidad(new Mordida("Mordida feroz", "te muerdo argg", getManaMaximo()/5, ataque * 2));
        //La mayoria de las habilidades dependeran de las estadisiticas base de las entidades
    }

    public Bestia(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
    }
}
