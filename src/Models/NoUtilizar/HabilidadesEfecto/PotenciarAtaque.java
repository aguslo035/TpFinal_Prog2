package Models.NoUtilizar.HabilidadesEfecto;

import Models.Entidades.Entidad;

public final class PotenciarAtaque extends HabilidadEfecto{
    private int bonusAtaque;
    private int danioOriginal;

    public PotenciarAtaque(String nombre, String descripcion, int danio, int costoMana, int turnosDuracion, int turnosRestantes, int bonusAtaque) {
        super(nombre, descripcion, danio, costoMana, turnosDuracion, turnosRestantes);
        this.bonusAtaque = bonusAtaque;
        danioOriginal = 0;
    }

    public PotenciarAtaque()
    {
        super("Potenciar Ataque", "Potencia tu ataque por 2 rondas.", 0, 5, 2, 2);
        this.bonusAtaque = 5;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    @Override
    public int lanzarHabilidadEfecto(Entidad obj) {
        int danioOriginalDeEntidad = obj.getAtaque();
        int danioAumentadoPorHabilidad = getBonusAtaque() + obj.getAtaque();

        obj.setAtaque(danioAumentadoPorHabilidad);
        setTurnosDuracion(2);
        setTurnosRestantes(getTurnosDuracion());

        danioOriginal = danioOriginalDeEntidad;

        obj.setEfecto(this);

        return danioAumentadoPorHabilidad;
    }

    @Override
    public void quitarEfectoActivo(Entidad obj) {
        obj.setAtaque(danioOriginal);
        obj.quitarEfecto();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonusAtaque=" + bonusAtaque +
                '}';
    }
}
