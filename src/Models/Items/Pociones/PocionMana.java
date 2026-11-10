package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;

public final class PocionMana extends Pocion{

    //constructor
    public PocionMana() {
        super("Pocion de Maná", 10);
    }

    //metodos
    @Override
    public void utilizar(Jugador jugador) {
        jugador.curar(getCantidad()); //después se elimina del inventario, no sé si ocurre en menuCombate o gestor inventario
    }

    @Override
    public String verEstadisticasItem() {
        return super.toString() + " MP+";
    }
}
