package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;
import Models.GestorDeTextoDeCombate;


public final class PocionVida extends Pocion{

    ///constructor
    public PocionVida() {
        super("Pocion de Vida", 10);
    }

    ///metodos

    //Devuelve la cantidad curada de vida.
    @Override
    public int utilizar(Jugador jugador) {
        return jugador.curar(getCantidad()); //después de hacer esto, se elimina del inventario en TurnoJugador
    }

    //Funciona como un toString de esta poción
    @Override
    public String verEstadisticasItem() {
        return super.toString() + " HP+";
    }

    //Describe lo que realizó el item en esta ronda y lo devuelve como String.
    public String describirComportamiento(Jugador usuario, int cantidad) { //no usa su propia cantidad, porque puede ser menor si se excede.
        return GestorDeTextoDeCombate.utilizacionItemDeRecuperarHP(usuario, getNombre(), cantidad);
    }
}
