package Models.Habilidades.HabilidadesEfecto;

public final class PotenciarAtaque extends HabilidadEfecto{
    private int bonusAtaque;

    public PotenciarAtaque(String nombre, String descripcion, int danio, int costoMana, int turnosDuracion, int turnosRestantes, int bonusAtaque) {
        super(nombre, descripcion, danio, costoMana, turnosDuracion, turnosRestantes);
        this.bonusAtaque = bonusAtaque;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    @Override
    public String toString() {
        return "PotenciarAtaque{" +
                "bonusAtaque=" + bonusAtaque +
                '}';
    }
}
