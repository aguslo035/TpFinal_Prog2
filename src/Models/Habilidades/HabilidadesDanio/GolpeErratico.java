package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Entidad;
import java.util.Random;

public final class GolpeErratico extends HabilidadDanio {
    private int multiplicadorMaximo;

    //creemoslo nosotros por defecto a las habilidades, para ir poniendola en los personajes/enemigos
    //mando números random en todas las habilidades (y te dejo esta nota en todas para que no se pierda)
    public GolpeErratico(String nombre, String descripcion, int danio, int costoMana, int multiplicadorMaximo) {
        super(nombre, descripcion, danio, costoMana);
        this.multiplicadorMaximo = multiplicadorMaximo;
    }

    //no sé qué es multiplicador máximo, voy con la idea del nro random, cambiar de ser necesario
    public GolpeErratico()
    {
        super("Golpe Errático", "La fuerza de este golpe puede llegar hasta el doble de tu poder de ataque.", 0, 7);
    } //no menciono el multiplicador maximo pq no sé qué es (son las 3 AM dificil pensar)
    //la forma de invocar esta habilidad es usar el metodo de calcular danio de debajo, que genera un danio random ese turno de acorde al ataque de la entidad
    //entonces le puse al atributo de daño "0" porque no se va a usar (puede que no la mejor solución inicializarlo así, pero es la más fácil que se me ocurrió en el momento)

    //toString reformateado (no llamo al super) por el tema de que el daño es 0
    @Override
    public String toString() {
        return "Habilidad: " +
                "nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", danio=" + " varía" +
                ", costoMana=" + getCostoMana() +
                ", multiplicadorMaximo=" + multiplicadorMaximo +
                '}';
    }

    @Override
    public int calcularDanio(Entidad usuario) { //para usar la habilidad se usa esto
        Random nroRandom = new Random();
        int ataque = usuario.getAtaque();
        return nroRandom.nextInt(ataque, (ataque*2)+1);
    }
}
