package Exception.Juego;

public class JuegoException extends Exception { // Se extiende de exception ya que quiero que los metodos que puedan tirar estas excepciones
                                                // sean chequeadas para que hagan algo con esa excepcion
    public JuegoException(String message) {
        super("Advertencia! " + message);
    }
}
