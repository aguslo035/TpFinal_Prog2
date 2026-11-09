package Models.Items.Pociones;

import Interface.IItem;

public abstract class Pocion implements IItem {

    //atributos
    private String nombre;
    private int cantidad;

    //constructor
    public Pocion(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //toString
    @Override
    public String toString() {
        return nombre + " -> " + cantidad;
    }

//    public static Pocion esPocion(IItem o)
//    {
//        if(o instanceof Pocion)
//            return (Pocion) o;
//        return null;
//    }

}
