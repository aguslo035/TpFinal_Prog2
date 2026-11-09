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
    private int defensa;
    private List<Habilidad> habilidades;

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
        Habilidad habilidadAUsar = habilidades.get(indice);

        int danioACausar = habilidadAUsar.getDanio();

        objetivo.setVidaActual(objetivo.getVidaActual() - danioACausar);

        return danioACausar;
    }

    @Override
    public String verHabilidades() {

        StringBuilder sb = new StringBuilder();
        int i = 0; //contador para mostrar lindamente el listado

        for (Habilidad h : habilidades)
        {
            sb.append("#"+ i + " - "); //quedaría ej "#0 - "
            sb.append(h.toString())
                    .append("\n"); //y esta magia pq esta así el .append y no da error
            i++;
        }

        return sb.toString();

    }

    @Override
    public boolean puedeUsarse(Entidad usuario) { //si esto es pregunta para si una habilidad puede usarse, puede convenga esté en la clase Habilidad. Hasta recibe una entidad cuando no es necesario en su propia clase
        return false;
    }

    public int atacar(Entidad objetivo) //no sé qué quiere que devuelva, el daño ocasionado?
    {
        objetivo.recibirDanio(this.getAtaque()); //es un ataque normal, el objetivo pierde daño acorde a la cantidad de ataque de esta entidad
        return this.getAtaque();
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
}
