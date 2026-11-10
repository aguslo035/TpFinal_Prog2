package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;

public final class PocionVida extends Pocion{

    //constructor
    public PocionVida() {
        super("Pocion de Vida", 10);
    }

    //metodos
    @Override
    public void utilizar(Jugador jugador) {
        jugador.recuperarMana(getCantidad()); //después se elimina del inventario, no sé si ocurre en menuCombate o gestor inventario
    }

    @Override
    public String verEstadisticasItem() {
        return super.toString() + " HP+";
    }
}
