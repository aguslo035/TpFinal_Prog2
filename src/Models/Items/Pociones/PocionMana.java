package Models.Items.Pociones;

import Models.Entidades.JugadoresClases.Jugador;

public final class PocionMana extends Pocion{

    //constructor
    public PocionMana() {
        super("Pocion de Maná", 10);
    }

    //metodos
    @Override
    public String verEstadisticasItem() {
        return super.toString() + " MP+";
    }
}
