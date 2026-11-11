package Exception.Juego;

public class InputNullException extends JuegoException { // Esto lo usamos para los scanners, asi nos ahorramos usarlo en todos
                                                        // los parametros de los metodos
    public InputNullException() {
        super("El dato ingresado no puede ser null!");
    }
}
