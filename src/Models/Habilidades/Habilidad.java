package Models.Habilidades;

import Exception.Juego.ManaInsuficienteException;
import Models.DanioOcasionado;
import Models.Entidades.Entidad;

public abstract class Habilidad {

    ///atributos
    private String nombre;
    private String descripcion;
    private int costoMana;

    ///constructor
    public Habilidad(String nombre, String descripcion, int costoMana) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMana = costoMana;
    }

    ///getters y setters
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

    ///Métodos

    //Indica true si tiene maná suficiente para usar la habilidad. False en caso contrario.
    public boolean sePuedeUsar(Entidad origen)
    {
        return origen.getManaActual() >= this.costoMana;
    }

    //Es la acción que realiza la habilidad. Devuelve el daño causado.
    //Cada hija decide si utiliza o no las entidades que se le pasan.
    public abstract DanioOcasionado usar(Entidad usuario, Entidad objetivo) throws ManaInsuficienteException;

    //Devuelve un string describiendo lo que realizó la habilidad hacia el jugador / los jugadores afectados.
    //Su razón de existir es para evitar poner muchos ifs en Gestor De Texto De Combate describiendo qué nombre poner de la habilidad por ejemplo.
    public abstract String describirComportamiento(Entidad origen, Entidad destino, DanioOcasionado danio);

    ///toString
    @Override
    public String toString() {
        return "Habilidad: " +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costoMana=" + costoMana; //le saqué la "cola" (}) porque puede haber habilidades con más datos
    }
}
