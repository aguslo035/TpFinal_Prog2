package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;
import Models.ConstructorDeTextoParaTurnos.GestorDeTextoDeCombate;

public final class PocionMana extends Pocion{

    //constructor
    public PocionMana() {
        super("Pocion de Maná", 10);
    }

    //metodos
    @Override
    public int utilizar(Jugador jugador) {
        return jugador.recuperarMana(getCantidad()); //después se elimina del inventario, no sé si ocurre en menuCombate o gestor inventario
    }

    @Override
    public String verEstadisticasItem() {
        return super.toString() + " MP+";
    }

    @Override
    public String describirComportamiento(Jugador usuario, int cantidad) { //no usa su propia cantidad, porque puede ser menor si se excede.
        return GestorDeTextoDeCombate.utilizacionItemDeRecuperarMP(usuario, getNombre(), cantidad);
    }
}
