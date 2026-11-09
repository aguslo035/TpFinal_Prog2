package Models.Entidades.Enemigos;

public final class Bestia extends Enemigo{
    public Bestia(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
    }

    public Bestia(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
    }
}
