package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;
import Models.GestorDeTextoDeCombate;

public final class PocionMana extends Pocion{

    ///constructor
    public PocionMana() {
        super("Pocion de Maná", 10);
    }

    ///metodos

    //Devuelve la cantidad curada de maná.
    @Override
    public int utilizar(Jugador jugador) {
        return jugador.recuperarMana(getCantidad()); //después se elimina del inventario, no sé si ocurre en menuCombate o gestor inventario
    }

    //Funciona como un toString de esta poción
    @Override
    public String verEstadisticasItem() {
        return super.toString() + " MP+";
    }

    //Describe lo que realizó el item en esta ronda y lo devuelve como String.
    @Override
    public String describirComportamiento(Jugador usuario, int cantidad) { //no usa su propia cantidad, porque puede ser menor si se excede.
        return GestorDeTextoDeCombate.utilizacionItemDeRecuperarMP(usuario, getNombre(), cantidad);
    }
}
