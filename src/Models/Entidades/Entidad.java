package Models.Entidades;

import Interface.IHabilidad;
import Models.Habilidades.Habilidad;
import Models.Habilidades.HabilidadesEfecto.HabilidadEfecto;

import java.util.ArrayList;
import java.util.List;

public abstract class Entidad implements IHabilidad {

    private String nombre;
    private int vidaActual;
    private int vidaMaxima;
    private int manaActual;
    private int manaMaximo;
    private int ataque;
    private int defensa;
    private List<Habilidad> habilidades;
    private HabilidadEfecto efectoActivo;


    public Entidad(String nombre, int vidaActual, int vidaMaxima,
                   int manaActual, int manaMaximo, int ataque,
                   int defensa) {

        this.nombre = nombre;
        this.vidaActual = vidaActual;
        this.vidaMaxima = vidaMaxima;
        this.manaActual = manaActual;
        this.manaMaximo = manaMaximo;
        this.ataque = ataque;
        this.defensa = defensa;
        habilidades = new ArrayList<>(); // Las habilidades son especificas de cada clase/enemigo. Se llena la lista con sus respectivas habildades en sus constructores
        efectoActivo = null; // todas las entidades comienzan sin efectos

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getManaActual() {
        return manaActual;
    }

    public void setManaActual(int manaActual) {
        this.manaActual = manaActual;
    }

    public int getManaMaximo() {
        return manaMaximo;
    }

    public void setManaMaximo(int manaMaximo) {
        this.manaMaximo = manaMaximo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "nombre='" + nombre + '\'' +
                ", vidaActual=" + vidaActual +
                ", vidaMaxima=" + vidaMaxima +
                ", manaActual=" + manaActual +
                ", manaMaximo=" + manaMaximo +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                '}';
    }

    @Override
    public int usarHabilidad(int indice, Entidad objetivo) {
        return 0;
    }

    @Override
    public String verHabilidades() {
        return "";
    }

    @Override
    public boolean puedeUsarse(Entidad usuario) {
        return false;
    }

    public int atacar(Entidad objetivo)
    {

    }

    public void recibirDanio(int danio)
    {

    }

    public void curar(int cantidad)
    {

    }

    public void recuperarMana(int cantidad)
    {
        // igual que curar
    }

    public boolean estaVivo()
    {

    }

    public String mostrarEstado()
    {

    }

    public void agregarEfectoHabilidad(HabilidadEfecto efecto)
    {

    }

    public void actualizarEfectoHabilidad()
    {
        
    }
}
