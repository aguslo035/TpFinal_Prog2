package Models.Entidades.Enemigos;

import Models.Habilidades.HabilidadesDanio.RoboDeVida;

public final class Demonio extends Enemigo{
    public Demonio(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.agregarHabilidad(new RoboDeVida("Robo de vida", "drena la vida de su víctima", this.getAtaque() + this.getAtaque() / 2,this.getManaMaximo() / 3 , this.getAtaque() + this.getAtaque() / 2));
    }

    public Demonio(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.agregarHabilidad(new RoboDeVida("Robo de vida", "drena la vida de su víctima", this.getAtaque() + this.getAtaque() / 2, this.getManaMaximo() / 3, this.getAtaque() + this.getAtaque() / 2));
    }
}
