package Models.Habilidades.HabilidadesDanio;

import Models.Entidades.Enemigos.Enemigo;
import Models.Entidades.Entidad;
import Models.Entidades.JugadoresClases.Jugador;
import Models.GestorDeTextoDeCombate;

public final class BolaDeFuego extends HabilidadDanio{

    public BolaDeFuego(String nombre, String descripcion, int costoMana, int danio) {
        super(nombre, descripcion, costoMana, danio);
    }
}
