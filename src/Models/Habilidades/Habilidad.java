package Models.Habilidades;

import Models.Entidades.Entidad;

public abstract class Habilidad {
    private String nombre;
    private String descripcion;
    private int costoMana;

    public Habilidad(String nombre, String descripcion, int costoMana) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMana = costoMana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCostoMana() {
        return costoMana;
    }

    public void setCostoMana(int costoMana) {
        this.costoMana = costoMana;
    }

    public boolean sePuedeUsar(Entidad obj)
    {
        return obj.getManaActual() >= this.costoMana;
    }

    public abstract int usar(Entidad usuario, Entidad objetivo); //Las hijas deciden como actuaran, es una opcion de diseño, por eso tambien se le pasa quien la utiliza por parametro si llegara a depender de alguna estadistica propia
    //devuelve el danio causado ^^^^^

    @Override
    public String toString() {
        return "Habilidad: " +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costoMana=" + costoMana; //le saqué la "cola" (}) porque puede haber habilidades con más datos
    }
}
