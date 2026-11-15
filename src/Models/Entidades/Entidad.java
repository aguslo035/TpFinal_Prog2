package Models.Entidades;

import Exception.Juego.IndiceInvalidoException;
import Exception.Juego.ManaInsuficienteException;
import Interface.IHabilidad;
import Models.DanioOcasionado;
import Models.Habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

public abstract class Entidad implements IHabilidad {

    //atributos
    private String nombre;
    private int vidaActual;
    private int vidaMaxima;
    private int manaActual;
    private int manaMaximo;
    private int ataque;
    private int escudo;
    private List<Habilidad> habilidades;

    //constructor
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

    //getters y setters
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

    public void setVidaMaxima(int vidaMaxima) { //Contempla intentar settear una vida máxima menor a 1.
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

    public List<Habilidad> getHabilidades ()
    {
        return this.habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    //Métodos

    @Override
    //Verifica que existe el hechizo que se quiere utilizar + que se tenga maná y lo utiliza en contra del objetivo. Devuelve el daño realizado a la vida.
    public DanioOcasionado usarHabilidad(int indice, Entidad objetivo) throws IndiceInvalidoException, ManaInsuficienteException {
        if (indice < 0 || indice > this.habilidades.size())
            throw new IndiceInvalidoException(indice);

        Habilidad habilidadAUsar = this.habilidades.get(indice);

        if(!habilidadAUsar.sePuedeUsar(this))
            throw new ManaInsuficienteException();

        this.manaActual -= habilidadAUsar.getCostoMana(); //ahora le resta maná al Jugador al usar la habilidad

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
            sb.append("#"+ i + " - "); //quedaría ej "#0 - (datos habilidad)"
            sb.append(h.toString())
                    .append("\n");
            i++;
        }

        return sb.toString();
    }


    public boolean agregarHabilidad(Habilidad habilidad) {
        return habilidades.add(habilidad);
    }

    public DanioOcasionado atacar(Entidad objetivo)
    {
        return objetivo.recibirDanio(this.ataque);
        //recibir danio es cuando recibe danio en su vida, pero igual, que este aca o en recibir danio es lo mismo. Una de las dos se tiene que encargar
        // de tomar en cuenta el escudo. O el atacante o el que lo recibe, por eso digo que en mi opinion da igual donde se tenga en cuenta
        // lo importante es que este en alguno de los dos
    }

    //Recibe una cantidad de daño. Resta el daño contra el escudo y vida de la entidad (primero se daña al escudo, después a la vida). El métod o devuelve un objeto que contiene datos sobre el daño ocasionado al escudo y a la vida.
    public DanioOcasionado recibirDanio(int danio)
    {
        DanioOcasionado resultado; //declaro el objeto que voy a devolver

        int danioARealizar = danio - this.escudo; //Del daño entrante, se quita la cantidad de escudo que se tiene. Si el escudo es superior, "danioARealizar" es negativo.

        if(danioARealizar < 0) { //ocurre si el escudo es mayor al ataque
            setEscudo(danioARealizar * (-1)); //Le coloca el nuevo escudo calculado a la entidad. *-1 porque el parametro debe ser positivo.
            return resultado = new DanioOcasionado(danio, 0, false); //se devuelve el daño realizado al escudo
        }

        if (danioARealizar == 0) { //Caso específico en el que daño recibido y el escudo son iguales.
            setEscudo(0);
            return resultado = new DanioOcasionado(danio, 0, true); //Este ataque rompe el escudo
        }

        //Se prosigue si el daño supera al escudo

        setVidaActual(this.vidaActual-danioARealizar); //El ataque calculado le quita vida a la entidad

        if (this.escudo > 0) //El primer ataque que sobrepase al escudo (si no se dio el caso de arriba) entra en este if. Significa que el ataque realizado rompe el escudo (leer el else).
        {
            resultado = new DanioOcasionado(this.escudo, danioARealizar, true);
            setEscudo(0);
            return resultado;
        }else //una vez el escudo este en 0, solamente se ataca a la vida
        {
            return resultado = new DanioOcasionado(0, danioARealizar, false);
        }
    }

    //Recibe una cantidad de curación y la suma a la vida actual. Contempla excederse del máximo. Devuelve la vida que efectivamente se curó.
    public int curar(int cantidad)
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

    //Recibe una cantidad de maná y la suma al maná actual. Contempla el caso de excederse del máximo posible. Devuelva el maná que efectivamente se regeneró.
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

    //Verifica si la entidad sigue viva (vida actual mayor a 0). Devuelve true si este es el caso.
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
                ", escudo=" + escudo;
    }
}
