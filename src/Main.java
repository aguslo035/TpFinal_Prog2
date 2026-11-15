import Controller.JuegoRPG;
import Exception.Conexion.ConexionException;
import java.sql.*;

import Jdbc.Conexion;
import Jdbc.ConexionClases;
import Jdbc.ConexionEnemigos;
import Models.Entidades.Enemigos.Orco;

void main() {

    //JuegoRPG.inicioJuego();

    //A hacer (de más importante a menos importante):
    //1)LO ARREGLÉ CREO: El menú de inventario, si tenés un item, no importa qué se elija, dice que estás ingresando un valor no valido. (para testeo tenés que matar al primer enemigo, recién ahí te da un item)
    //^ lo arreglé (CREO) sin querer al arreglar los indices de GestoraDeItems
    //2) No entiendo dónde usar "IndiceInvalidoException", agregué muchos listados pero no sé cómo ni en cuales ponerlo. Tal vez por sueño.
    //3) Ahora mismo hay 2 clases con scanners (JuegoRPG y TurnoJugador), hay que hacer que todos los scanners usen el scanner de JuegoRPG (es decir, borrar el scanner de TurnoJugador, pero hay que cambiar los llamados a scanners dentro de esa clase y también en caso de que otras clases que llamen al scanner de TurnoJugador)
    //4) [HECHO] Al inspeccionar al enemigo en TurnoJugador, se debe de poder también ver qué habilidad tiene (creo que hay que cambiar el toString de Entidad)
    //5) Cambiar nombre de el Enum "TipoArma" por "ETipoArma" sin que se rompa todo
    //6) Hay muchos espacios de más al abrir el menú de habilidades.




//    try {
//        ConexionClases.crearTablaClases();
//    } catch (ConexionException e) {
//        System.out.println(e.getMessage());
//    }
}
