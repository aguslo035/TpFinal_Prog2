package Models;

//Representa el daño que recibe una entidad a sus atributos por cualquier ataque. Existe para que la gestora muestre correctamente lo que ocurre en un turno.
public class DanioOcasionado {

    ///atributos
    private final int danioAlEscudo;
    private final int danioALaVida;
    private final boolean rompeEscudo; //indica true si el ataque rompió el escudo (de settear esto se encarga Entidad.recibirDanio())

    ///constructores
    public DanioOcasionado(int danioAlEscudo, int danioALaVida, boolean rompeEscudo) {
        this.danioAlEscudo = danioAlEscudo;
        this.danioALaVida = danioALaVida;
        this.rompeEscudo = rompeEscudo;
    }

    //No quiero que tenga setters. Una vez creado va a ser utilizado una vez, no es necesario sea modificado.
    public int getDanioAlEscudo() {
        return danioAlEscudo;
    }

    public int getDanioALaVida() {
        return danioALaVida;
    }

    public boolean isRompeEscudo() {
        return rompeEscudo;
    }
}
