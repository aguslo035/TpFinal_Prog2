package Models;

import Models.Entidades.Entidad;

//en realidad no es un "gestor" de colección, pero dependiendo de la acción gestiona qué texto se le muestra al usuario. Se utiliza en TurnoJugador y TurnoEnemigo
public abstract class GestorDeTextoDeCombate {

    //Devuelve texto de realización de un ataque normal.
    public static String ataque(Entidad origen, Entidad objetivo, DanioOcasionado danio)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(origen.getNombre() + " ataca a "+ objetivo.getNombre());

        logicaAtaqueAVidaOEscudo(sb, danio); //en este método_ el texto cambia dependiendo de si se ataca al escudo, la vida, ambos, o si un ataque rompió el escudo.

        return sb.toString();
    }

    ///Los siguientes métodos son llamados por una habilidad para describir su acción en una ronda.

    //Devuelve un string describiendo el daño realizado por una habilidad de daño.
    public static String ataqueHabilidad (Entidad origen, Entidad objetivo, String nombreHabilidad, DanioOcasionado danio)
    {
        StringBuilder sb = new StringBuilder();

        return origen.getNombre() + " utiliza su habilidad "+ nombreHabilidad + " contra "+ objetivo.getNombre() + logicaAtaqueAVidaOEscudo(sb, danio);
    }

    //Devuelve un string describiendo el daño y la cura realizada por una habilidad que daña Y cura.
    public static String ataqueHabilidadConCura(Entidad origen, Entidad objetivo, String nombreHabilidad, DanioOcasionado danio)
    {
        StringBuilder sb = new StringBuilder();
        int danioTotal = danio.getDanioAlEscudo() + danio.getDanioALaVida();

        sb.append(ataqueHabilidad(origen, objetivo, nombreHabilidad, danio));
        sb.append("\nComo consecuencia de la habilidad, "+ origen.getNombre() + " se cura por "+ danioTotal + " de vida!\n");

        return sb.toString();
    }

    //Método_ intermedio de utilización de item. Es para no repetir cada vez que se agrega un nuevo tipo de item.
    private static String utilizacionItem (Entidad origen, String nombreItem)
    {
        return origen.getNombre() + " utiliza el item "+ nombreItem + "!\n";
    }

    //Método_ intermedio de utilización de item de recuperación. Es para no repetir en caso de que se agregue un nuevo tipo de recuperación (ej, de escudo, o nuevos atributos).
    private static String utilizarItemDeRecuperar(Entidad origen, int cantidadDeRecuperacion)
    {
        return origen.getNombre() + " ha recuperado "+ cantidadDeRecuperacion;
    }

    //Devuelve un string describiendo recuperación de vida al utilizar un item.
    public static String utilizacionItemDeRecuperarHP (Entidad origen, String nombreItem, int cantCura)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(utilizacionItem(origen, nombreItem));
        sb.append(utilizarItemDeRecuperar(origen, cantCura) + " de vida!\n");

        return sb.toString();
    }

    //Devuelve un string describiendo recuperación de maná al utilizar un item.
    public static String utilizacionItemDeRecuperarMP (Entidad origen, String nombreItem, int cantCura)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(utilizacionItem(origen, nombreItem));
        sb.append(utilizarItemDeRecuperar(origen, cantCura)+ " de MP!\n");

        return sb.toString();
    }

    //Devuelve un string con datos relevantes de la entidad recibida.
    public static String mostrarEstado(Entidad entidadRecibida)
    {
        String texto = entidadRecibida.getNombre() +  " | Escudo Restante: "+ entidadRecibida.getEscudo() + " | Vida Restante: "+ entidadRecibida.getVidaActual() + "| Maná restante: "+ entidadRecibida.getManaActual();

        return texto; //quedaría ejemplo: Guerrero Tomás | Escudo restante: 30 | Vida Restante: 10 | Maná restante: 5
    }

    //Proveé el texto exacto de si se ha hecho daño al escudo, a la vida, o ambos. Incluye mención especial si un ataque rompe el escudo.
    private static String logicaAtaqueAVidaOEscudo(StringBuilder sb, DanioOcasionado danio)
    {
        //Los ifs están explícitos para claridad de la lógica
        if (!danio.isRompeEscudo()) //ataques que NO llevan el escudo a 0
        {
            if (danio.getDanioAlEscudo() > 0 && danio.getDanioALaVida() <= 0) //es un ataque que solo resta puntos de escudo
            {
                sb.append(ataqueAEscudo(danio));
            }

            if (danio.getDanioALaVida() > 0) //es un ataque directo a la vida. El escudo ya está roto en este caso.
            {
                sb.append(ataqueDaniaVida(danio));
            }
        }

        if (danio.isRompeEscudo()) //ocurre cuando un ataque lleva el escudo a 0
        {
            if (danio.getDanioALaVida() > 0) //es un ataque que rompe el escudo, y queda daño excedente para dañar la vida.
            {
                sb.append(ataqueRompeEscudoYDania(danio));
            }else //es para ataques que son exactamente igual al escudo, entonces solo lo rompen.
            {
                sb.append(ataqueRompeEscudo(danio));
            }
        }

        return sb.toString();
    }

    private static String ataqueAEscudo(DanioOcasionado danio)
    {
        return ", dañando su escudo por "+ danio.getDanioAlEscudo() +" de daño!\n";
    }

    private static String ataqueDaniaVida(DanioOcasionado danio)
    {
        return ", quitandole "+ danio.getDanioALaVida() + " de vida!\n";
    }

    private static String ataqueRompeEscudoYDania(DanioOcasionado danio)
    {
        return ", rompiendole el escudo por "+ danio.getDanioAlEscudo() +" de daño... Recibe "+ danio.getDanioALaVida() + " de daño a su vida.\n";
    }

    private static String ataqueRompeEscudo(DanioOcasionado danio)
    {
        return ", rompiendo su escudo por "+ danio.getDanioAlEscudo() + " de daño!\n";
    }


}
