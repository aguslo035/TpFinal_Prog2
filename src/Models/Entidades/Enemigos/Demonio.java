package Models.Entidades.Enemigos;

public final class Demonio extends Enemigo{
    public Demonio(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
    }

    public Demonio(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
    }
}
