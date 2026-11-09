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
        habilidades = new ArrayList<>();
        efectoActivo = new //completar;
    }
}
