package Models.Entidades.JugadoresClases;

import Controller.GestoraDeItems;
import Enumerator.ETipoArma;
import Exception.Juego.IndiceInvalidoException;
import Interface.IItem;
import Models.Entidades.Entidad;
//import Models.Items.Pociones.Pocion;
//import Models.Items.Pociones.VerificarItem;

import java.util.Objects;

public abstract class Jugador extends Entidad {

    ///atributos
    private final int id;
    private final ETipoArma eTipoArma;
    private GestoraDeItems<IItem> inventario;

    ///constructores
    public Jugador(String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, ETipoArma eTipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.eTipoArma = eTipoArma;
        this.id = 0;

        inventario = new GestoraDeItems<>(); // con <> utiliza el tipo de dato utilizado en su referencia
    }

    public Jugador(int id, String nombre, int vidaActual, int vidaMaxima, int manaActual, int manaMaximo, int ataque, int escudo, ETipoArma eTipoArma) {
        super(nombre, vidaActual, vidaMaxima, manaActual, manaMaximo, ataque, escudo);
        this.eTipoArma = eTipoArma;
        this.id = id;

        inventario = new GestoraDeItems<>();
    } // lo mismo de la id que enemigo, para que no se repita al traerlos de la base de datos

    ///getters y setters
    public int getId() {
        return id;
    }

    public ETipoArma getTipoArma() {
        return eTipoArma;
    }

    public boolean agregarItem(IItem item)
    {
        return inventario.agregarElemento(item);
    }

    public void eliminarItem(int indice)
            throws IndiceInvalidoException
    {
        if(indice < 0 || indice >= inventario.obtenerTamanio())
            throw new IndiceInvalidoException(indice);
        inventario.eliminarElemento(indice);
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

    ///métodos
    public int utilizarItem(int indice)
        throws IndiceInvalidoException
    {
        if(indice < 0 || indice >= inventario.obtenerTamanio())
            throw new IndiceInvalidoException(indice);

        return inventario.obtenerElemento(indice).utilizar(this);
    }


    //equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;
        return id == jugador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //toString
    @Override
    public String toString() {
        return "id=" + id +
                super.toString() +
                ", eTipoArma=" + eTipoArma +
                ", inventario=" + inventario.listar(); //acá imprimimos todo el array del inventario?
    }

    //otro tipo de toString que imprime solo datos relevantes para decidir qué clase elegir.
    public String datosParaEleccion()
    {
        return "Nombre: "+ getNombre() +
                ", Vida: "+ getVidaMaxima() +
                ", Maná(MP): "+ getManaMaximo() +
                ", Ataque: " + getAtaque() +
                ", Escudo: "+ getEscudo() +
                ", Arma Utilizada: "+ this.eTipoArma;
    }
}
