import Controller.JuegoRPG;
import Exception.Conexion.ConexionException;
import java.sql.*;
import Jdbc.ConexionClases;

void main() {

    JuegoRPG.inicioJuego();

    //A hacer (de más importante a menos importante):
    //- El menú de inventario, al seleccionar un item, dice que estás ingresando un valor no valido. (para testeo tenés que matar al primer enemigo para tener un item)
    
    //- Ahora mismo hay 2 clases con scanners, hay que hacer que todos los scanners usen el scanner de JuegoRPG
    //

//    try {
//        ConexionClases.crearTablaClases();
//    } catch (ConexionException e) {
//        System.out.println(e.getMessage());
//    }
}
