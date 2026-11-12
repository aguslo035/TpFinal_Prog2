package Models.Habilidades;

import Exception.Juego.ManaInsuficienteException;
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
        return obj.getManaActual() >= this.costoMana; // devuelve true o false, si ponemos una excepcion nunca sera false
    }

    //Es la acción que realiza la habilidad. Devuelve el daño causado.
    public abstract int usar(Entidad usuario, Entidad objetivo) throws ManaInsuficienteException;
    //Las hijas deciden como actuaran. Pueden decidir o no utilizar las entidades que se le pasan.

    //Devuelve un string describiendo lo que se realizó para el jugador.
    public abstract String describirComportamiento(Entidad origen, Entidad destino, int danio);

    //toString
    @Override
    public String toString() {
        return "Habilidad: " +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costoMana=" + costoMana; //le saqué la "cola" (}) porque puede haber habilidades con más datos
    }
}
