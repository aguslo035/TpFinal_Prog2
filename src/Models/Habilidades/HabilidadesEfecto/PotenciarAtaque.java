package Models.Habilidades.HabilidadesEfecto;

import Models.Entidades.Entidad;

public final class PotenciarAtaque extends HabilidadEfecto{
    private int bonusAtaque;

    public PotenciarAtaque(String nombre, String descripcion, int danio, int costoMana, int turnosDuracion, int turnosRestantes, int bonusAtaque) {
        super(nombre, descripcion, danio, costoMana, turnosDuracion, turnosRestantes);
        this.bonusAtaque = bonusAtaque;
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
    public int alLanzarHabilidad(Entidad usuario, Entidad enemigo) {
        //sé que hace pero a la vez no sé como representarlo
        //hasta puede que no convenga esté este metodo acá, por ahora lo puse en el padre "Habilidad" para poder ejecutar habilidades en el arraylist de habilidades en Entidad
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonusAtaque=" + bonusAtaque +
                '}';
    }
}
