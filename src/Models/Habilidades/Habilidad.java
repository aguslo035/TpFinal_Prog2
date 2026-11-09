package Models.Habilidades;

import Models.Entidades.Entidad;

public abstract class Habilidad {
    private String nombre;
    private String descripcion;
    //no entendí pq pasaste daño aca
    private int danio;
    private int costoMana;

    public Habilidad(String nombre, String descripcion, int danio, int costoMana) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.danio = danio;
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

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getCostoMana() {
        return costoMana;
    }

    public void setCostoMana(int costoMana) {
        this.costoMana = costoMana;
    }

    //metodo
    //lo comento pero en vez de estar en habilidadDanio como hice, tal vez convenga esté acá
//    public void ejecutarHabilidad(Entidad usuario, Entidad enemigo){
//
//    }

    @Override
    public String toString() {
        return "Habilidad: " +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", danio=" + danio +
                ", costoMana=" + costoMana; //le saqué la "cola" (}) porque puede haber habilidades con más datos
    }
}
