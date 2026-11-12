package Models;

import Models.Entidades.Entidad;

//en realidad no es un "gestor" de colección, pero no sé cómo ponerlo sino
public abstract class GestorDeTextoDeCombate { //es para el llamado "flavor text". Va a usarse en TurnoJugador y TurnoEnemigo

    public static String ataque(Entidad origen, Entidad objetivo, int danio)
    {
        return origen.getNombre() + " ataca a "+ objetivo.getNombre() + " por "+ danio + " de daño!\n";
    }

    public static String ataqueHabilidad (Entidad origen, Entidad objetivo, String nombreHabilidad, int danio)
    {
        return origen.getNombre() + " utiliza su habilidad "+ nombreHabilidad + " contra "+ objetivo.getNombre() + " y ocasiona "+ danio + " de daño!";
    }

    public static String ataqueHabilidadConCura(Entidad origen, Entidad objetivo, String nombreHabilidad, int danio, int cura)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(ataqueHabilidad(origen, objetivo, nombreHabilidad, danio));
        sb.append(origen.getNombre() + " se cura por "+ cura + " de vida!\n");

        return sb.toString();
    }

    private static String utilizacionItem (Entidad origen, String nombreItem) //como es un método intermedio, no quiero se pueda acceder de fuera
    {
        return origen.getNombre() + " utiliza el item "+ nombreItem + "!\n";
    }

    //el comentario de arriba aplica a este también
    private static String utilizarItemDeRecuperar(Entidad origen, int cantidadDeRecuperacion) //es por si algún día agregamos otros tipos de recuperación estadística (ej escudo u nuevos atributos que decidamos implementar). Sino se termina repitiendo este mismo texto mucho.
    {
        return origen.getNombre() + " ha recuperado "+ cantidadDeRecuperacion;
    }

    public static String utilizacionItemDeRecuperarHP (Entidad origen, String nombreItem, int cantCura)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(utilizacionItem(origen, nombreItem));
        sb.append(utilizarItemDeRecuperar(origen, cantCura) + " de vida!\n");

        return sb.toString();
    }

    public static String utilizacionItemDeRecuperarMP (Entidad origen, String nombreItem, int cantCura)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(utilizacionItem(origen, nombreItem));
        sb.append(utilizarItemDeRecuperar(origen, cantCura)+ " de MP!\n");

        return sb.toString();
    }

    public static String mostrarEstado(Entidad entidadRecibida)
    {
        String texto = entidadRecibida.getNombre() + " | Vida Restante: "+ entidadRecibida.getVidaActual() + ", Escudo: "+ entidadRecibida.getEscudo() +  ", Maná restante: "+ entidadRecibida.getManaActual();

        return texto; //quedaría ejemplo: Guerrero Tomás | Vida restante: 10, Escudo: 30, Maná restante: 5
    }




}
