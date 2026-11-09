package Models.Entidades.JugadoresClases;

import Controller.GestoraDeItems;
import Enumerator.TipoArma;
import Models.Entidades.Entidad;
//import Models.Items.Pociones.Pocion;
//import Models.Items.Pociones.VerificarItem;

import java.util.Objects;

public abstract class Jugador extends Entidad {
    private static int idAux = 0;
    private final int id;
    private final TipoArma tipoArma;
    private GestoraDeItems inventario;

    public Jugador(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int defensa, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, defensa);
        this.tipoArma = tipoArma;
        id = idAux;
        idAux++;

        inventario = new GestoraDeItems();
    }

    public int getId() {
        return id;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;
        return id == jugador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //no queres imprimir más datos de entidad? ej, ataque, vida, defensa, etc?
    //por ahora saco el jugador{ para llamar el toString en los hijos y quede lindo (sino queda Guerrero{Jugador{(datos)}} )
    @Override
    public String toString() {
        return "id=" + id +
                ", tipoArma=" + tipoArma +
                ", inventario=" + inventario; //acá imprimimos todo el array del inventario?
    }

    //tomo lo de wsp como que lo revierta
    //no quiero modificar este metodo con instance of/ifs cada vez que se agrega un tipo de objeto
//    public void usarItem(int indice)
//    {
//        Pocion p = Pocion.esPocion(inventario.obtener(1));
//        if(p == null)
//            //exception
//
//    }
}
