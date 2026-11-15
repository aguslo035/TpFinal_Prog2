package Models.Entidades.JugadoresClases;

import Enumerator.ETipoArma;
import Models.Habilidades.HabilidadesDanio.GolpeErratico;

public final class Guerrero extends Jugador{

    public Guerrero(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, ETipoArma eTipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, eTipoArma);
        this.agregarHabilidad(new GolpeErratico("Golpe brutal", "un tajo con toda su fuerza", this.getManaMaximo() / 4, this.getAtaque(), this.getAtaque() / 2));
    }

    public Guerrero(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, ETipoArma eTipoArma) {
        super(id, nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo, eTipoArma);
        this.agregarHabilidad(new GolpeErratico("Golpe brutal", "un tajo con toda su fuerza", this.getManaMaximo() / 4, this.getAtaque(), this.getAtaque() / 2));
    }

    //sin esto al llamar al toString va a imprimir "jugador" en vez de "guerrero"
    @Override
    public String toString() {
        return "Guerrero{"+ super.toString();
    }
}
