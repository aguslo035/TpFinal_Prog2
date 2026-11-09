package Models.Habilidades.HabilidadesEfecto;

import Models.Entidades.Entidad;
import Models.Habilidades.Habilidad;

public abstract class HabilidadEfecto extends Habilidad {

    //si la lógica de los efectos se vuelve horrible, diría removerlos
    //veremos
    private int turnosDuracion;
    private int turnosRestantes;

    public HabilidadEfecto(String nombre, String descripcion, int danio, int costoMana, int turnosDuracion, int turnosRestantes) {
        super(nombre, descripcion, danio, costoMana);
        this.turnosDuracion = turnosDuracion;
        this.turnosRestantes = turnosRestantes;
    }

    public int getTurnosDuracion() {
        return turnosDuracion;
    }

    public void setTurnosDuracion(int turnosDuracion) {
        this.turnosDuracion = turnosDuracion;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    public void aplicarEfecto(Entidad objetivo)
    {

    }

    public void quitarEfecto()
    {

    }

    public void restarUnTurno(){
        if (getTurnosRestantes() <= 0)
            setTurnosRestantes(getTurnosRestantes() - 1);
    }

    @Override
    public String toString() {
        return "HabilidadEfecto{" +
                "turnosDuracion=" + turnosDuracion +
                ", turnosRestantes=" + turnosRestantes +
                '}';
    }
}
