package Exception.Conexion;

public class ConexionException extends Exception { // Se extiende de exception ya que quiero que los metodos que puedan tirar estas excepciones
                                                    // sean chequeadas para que hagan algo con esa excepcion
    public ConexionException(String message) {
        super("Advertencia en la Base de Datos! " + message);
    }
}
