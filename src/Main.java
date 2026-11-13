import Controller.JuegoRPG;
import Exception.Conexion.ConexionException;
import java.sql.*;
import Jdbc.ConexionClases;

void main() {

    //JuegoRPG.inicioJuego();

    try {
        ConexionClases.crearTablaClases();
    } catch (ConexionException e) {
        System.out.println(e.getMessage());
    }
}
