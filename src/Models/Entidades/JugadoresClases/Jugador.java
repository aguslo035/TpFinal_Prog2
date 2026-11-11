package Models.Entidades.JugadoresClases;

import Controller.GestoraDeItems;
import Enumerator.TipoArma;
import Interface.IItem;
import Models.Entidades.Entidad;
//import Models.Items.Pociones.Pocion;
//import Models.Items.Pociones.VerificarItem;

import java.util.Objects;

public abstract class Jugador extends Entidad {
    private static int idAux = 0;
    private final int id;
    private final TipoArma tipoArma;
    private GestoraDeItems<IItem> inventario;

    public Jugador(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.tipoArma = tipoArma;
        id = idAux;
        idAux++;

        inventario = new GestoraDeItems<>(); // con <> utiliza el tipo de dato utilizado en su referencia
    }

    public Jugador(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, TipoArma tipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.tipoArma = tipoArma;
        this.id = id;

        inventario = new GestoraDeItems();
    } // lo mismo de la id que enemigo, para que no se repita al traerlos de la base de datos

    public int getId() {
        return id;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    public boolean agregarItem(IItem item)
    {
        return inventario.agregarElemento(item);
    }

    public void eliminarItem(int indice)
    {
        inventario.eliminarElemento(indice);
    }

    public int utilizarItem(int indice)
    {
        return inventario.obtenerElemento(indice).utilizar(this);
    }

    public void eliminarItem(IItem item)
    {
        inventario.eliminarElemento(item);
    }

    public GestoraDeItems<IItem> getInventario()
    {
        return inventario;
    }

    public String listarInventario()
    {
        return inventario.listar();
    }

    public int contarItemsInventario()
    {
        return inventario.contarElementos();
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

    //no queres imprimir más datos de entidad? ej, ataque, vida, escudo, etc?
    //por ahora saco el jugador{ para llamar el toString en los hijos y quede lindo (sino queda Guerrero{Jugador{(datos)}} )
    @Override
    public String toString() {
        return "id=" + id +
                super.toString() +
                ", tipoArma=" + tipoArma +
                ", inventario=" + inventario.listar(); //acá imprimimos todo el array del inventario?
    }
}
