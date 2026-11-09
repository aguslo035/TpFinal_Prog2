package Models.Entidades;

import Interface.IHabilidad;
import Models.Habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

public abstract class Entidad implements IHabilidad {

    private String nombre;
    private int vidaActual;
    private int vidaMaxima;
    private int manaActual;
    private int manaMaximo;
    private int ataque;
    private int escudo;
    private List<Habilidad> habilidades;

    public Entidad(String nombre, int vidaActual, int vidaMaxima,
                   int manaActual, int manaMaximo, int ataque,
                   int escudo) {

        this.nombre = nombre;
        this.vidaActual = vidaActual; //hay que poner checks de que la vida y maná actual no pueda superar a la maxima acá. Por ahora los pongo en los setters
        this.vidaMaxima = vidaMaxima;
        this.manaActual = manaActual;
        this.manaMaximo = manaMaximo;
        this.ataque = ataque;
        this.escudo = escudo;
        habilidades = new ArrayList<>(); // Las habilidades son especificas de cada clase/enemigo. Se llena la lista con sus respectivas habildades en sus constructores
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
        if(vidaActual <= this.vidaMaxima)
        {
            this.vidaActual = vidaActual;
        }
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) { //tal vez checks de que la vida máxima no pueda ser menor a 1, pero no quiero engorrarme en los detalles ahora mismo. Solo dejo constancia.
        this.vidaMaxima = vidaMaxima;
    }

    public int getManaActual() {
        return manaActual;
    }

    public void setManaActual(int manaActual) {
        if(manaActual <= this.manaMaximo)
        {
            this.manaActual = manaActual;
        }
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

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    @Override
    public int usarHabilidad(int indice, Entidad objetivo) {
        Habilidad habilidadAUsar = habilidades.get(indice);
        return habilidadAUsar.usar(this, objetivo);
    }

    @Override
    public String verHabilidades() {

        StringBuilder sb = new StringBuilder();
        int i = 0; //contador para mostrar lindamente el listado

        for (Habilidad h : habilidades)
        {
            sb.append("#"+ (i+1) + " - "); //quedaría ej "#1 - "
            sb.append(h.toString())
                    .append("\n"); //y esta magia pq esta así el .append y no da error
            i++;
        }

        return sb.toString();
    }

    public boolean agregarHabilidad(Habilidad habilidad) {
        return habilidades.add(habilidad);
    }

    public int atacar(Entidad objetivo)
    {
        int danioARealizar = this.ataque - objetivo.getEscudo();
        if(danioARealizar < 0) {
            objetivo.recibirDanio(0); //es un ataque normal, el objetivo pierde daño acorde a la cantidad de ataque de esta entidad
            //^ nos podemos ahorrar esta linea
            objetivo.setEscudo(danioARealizar * (-1));
            return 0;
        }
        objetivo.recibirDanio(danioARealizar);
        objetivo.setEscudo(0); //si el escudo ya está en 0 se continúa setteando en 0? puede ser preferible un if preguntando si escudo 0 para evitar eso
        return danioARealizar;
    }

    public void recibirDanio(int danio)
    {
        setVidaActual(getVidaActual()-danio);
    }

    public void curar(int cantidad) //contempla excederse
    {
        int nuevaVida = getVidaActual()+cantidad;

        if (nuevaVida > vidaMaxima){ //puede esto pueda modularizarse
            setVidaActual(vidaMaxima);
        }else {
            setVidaActual(nuevaVida);
        }
    }

    public void recuperarMana(int cantidad) //contempla excederse
    {
        int nuevoMana = getManaActual()+cantidad;

        if (nuevoMana > manaMaximo)
        {
            setManaActual(manaMaximo);
        }else {
            setManaActual(nuevoMana);
        }
    }

    public boolean estaVivo()
    {
        if (getVidaActual() > 0)
        {
            return true;
        }
        return false;
    }

    public String mostrarEstado()
    {
        StringBuilder sb = new StringBuilder(getNombre() + " | Vida Restante: "+ vidaActual + ", Maná restante: "+ manaActual);

        return sb.toString(); //quedaría ejemplo: Guerrero Tomás | Vida restante: 10, Maná restante: 5, Efecto activo: PotenciarAtaque
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
                ", escudo=" + escudo +
                '}';
    }
}
