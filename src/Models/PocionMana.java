package Models;

public class PocionMana extends Pocion{

    //constructor
    public PocionMana() {
        super("Pocion de Maná", 10);
    }

    //metodos
    @Override
    public String verEstadisticasItem() {
        return super.toString() + " MP+";
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.recuperarMana(getCantidad());
    }
}
