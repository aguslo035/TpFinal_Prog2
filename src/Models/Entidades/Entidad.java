package Models.Entidades;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
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
        if (vidaActual >= getVidaMaxima())
            this.vidaActual = getVidaMaxima();
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) { //tal vez checks de que la vida máxima no pueda ser menor a 1, pero no quiero engorrarme en los detalles ahora mismo. Solo dejo constancia.
        if (vidaMaxima >= 1)
            this.vidaMaxima = vidaMaxima;
        else
            this.vidaMaxima = 1;
    }

    public int getManaActual()
    {
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
    public int usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException, ManaInsuficienteException {
        if (indice < this.habilidades.size() || indice >this.habilidades.size())
            throw new IndiceInvalidoException(indice);

        Habilidad habilidadAUsar = this.habilidades.get(indice);
        if(!habilidadAUsar.sePuedeUsar(this))
            throw new ManaInsuficienteException();

        return habilidadAUsar.usar(this, objetivo);
    }

    public int contarHabilidades() //lo necesito para un método en turnoJugador
    {
        return habilidades.size();
    }

    @Override
    public String verHabilidades() {

        StringBuilder sb = new StringBuilder();
        int i = 0; //contador para mostrar lindamente el listado

        for (Habilidad h : habilidades)
        {
            sb.append("#"+ i + " - "); //quedaría ej "#0 - " -> veo que le agregaste +1 para estilización, voy a obligarlo a elegir un listado empezando de 0 para simplificar.
            sb.append(h.toString())
                    .append("\n");
            i++;
        }

        return sb.toString();
    }

    public List<Habilidad> getHabilidades ()
    {
        return this.habilidades;
    }

    public boolean agregarHabilidad(Habilidad habilidad) {
        return habilidades.add(habilidad);
    }

    public int atacar(Entidad objetivo) //Si me acuerdo después de terminar MenuCombate te consulto, pero esta lógica de qué ocurre en el enemigo si hay X cantidad de daño debería estar en recibirDanio. Que cada entidad que reciba un daño se encarge de gestionar su propio escudo y vida, que no se encarge de eso la persona que ataca (para eso está recibirDaño)
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
        //recibir danio es cuando recibe danio en su vida, pero igual, que este aca o en recibir danio es lo mismo. Una de las dos se tiene que encargar
        // de tomar en cuenta el escudo. O el atacante o el que lo recibe, por eso digo que en mi opinion da igual donde se tenga en cuenta
        // lo importante es que este en alguno de los dos
    }

    public void recibirDanio(int danio)
    {
        setVidaActual(getVidaActual()-danio);
    }

    public int curar(int cantidad) //contempla excederse
    {
        int nuevaVida = getVidaActual()+cantidad;

        if (nuevaVida > vidaMaxima){ //puede esto pueda modularizarse
            cantidad = cantidad - (nuevaVida - vidaMaxima); //esta es la cantidad que efectivamente se cura
            setVidaActual(vidaMaxima);
        }else {
            setVidaActual(nuevaVida);
        }

        return cantidad;
    }

    public int recuperarMana(int cantidad) //contempla excederse
    {
        int nuevoMana = getManaActual()+cantidad;

        if (nuevoMana > manaMaximo)
        {
            cantidad = cantidad - (nuevoMana - manaMaximo);
            setManaActual(manaMaximo);
        }else {
            setManaActual(nuevoMana);
        }

        return cantidad;
    }

    public boolean estaVivo()
    {
        if (getVidaActual() > 0)
        {
            return true;
        }
        return false;
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
