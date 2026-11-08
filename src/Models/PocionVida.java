package Models;

public class PocionVida extends Pocion{

    //constructor
    public PocionVida() {
        super("Pocion de Vida", 10);
    }

    //metodos
    @Override
    public String verEstadisticasItem() {
        return super.toString() + " HP+";
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.curar(getCantidad());
    }


}
