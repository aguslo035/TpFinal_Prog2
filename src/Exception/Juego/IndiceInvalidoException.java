package Exception.Juego;

public class IndiceInvalidoException extends RuntimeException {
    public IndiceInvalidoException(int indiceFueraDeRango) {
        super("El indice utilizado: [" + indiceFueraDeRango + "]. NO es valido!");
    }
}
