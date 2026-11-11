package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;

public final class PocionVida extends Pocion{

    //constructor
    public PocionVida() {
        super("Pocion de Vida", 10);
    }

    //metodos
    @Override
    public int utilizar(Jugador jugador) {
        return jugador.curar(getCantidad()); //después se elimina del inventario, no sé si ocurre en menuCombate o gestor inventario
        // respondiendo a lo tuyo, se eliminaria en menuCombate, primero se llama utilizar y luego se llama inventario.eliminarElemento(indice de esta pocion)
    }

    @Override
    public String verEstadisticasItem() {
        return super.toString() + " HP+";
    }
}
