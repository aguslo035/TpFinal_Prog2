package Models.Entidades.Enemigos;

import Models.Habilidades.HabilidadesDanio.GolpeErratico;

public final class Orco extends Enemigo{
    public Orco(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.agregarHabilidad(new GolpeErratico("Golpe salvaje", "un garrotazo impredecible", this.getManaMaximo() / 4, this.getAtaque(), 3));
    }

    public Orco(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.agregarHabilidad(new GolpeErratico("Golpe salvaje", "un garrotazo impredecible", this.getManaMaximo() / 4, this.getAtaque(), 3));
    }
}
