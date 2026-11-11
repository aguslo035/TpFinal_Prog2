package Exception.Conexion;

public class ConexionException extends Exception { // Lo mismo que Juego exception
    public ConexionException(String message) {
        super("Advertencia en la Base de Datos! " + message);
    }
}
