package Controller;

import Exception.Juego.IndiceInvalidoException;
import Interface.IItem;

import java.util.ArrayList;
import java.util.List;

public class GestoraDeItems<T extends IItem> {
    /* Al hacer la gestora de items generica a partir de IItem se puede utilizar para varias cosas
     por ejemplo un cofre de pociones, o asegurar para un futuro manejo de otros tipos de items
     sin importar lo que sean, por ejemplo una tienda de armas*/
    private List<T> elementos;

    public GestoraDeItems() {
        elementos = new ArrayList<>();
    }

    public List<T> getElementos () //me acabo de dar cuenta que en realidad no era necesario jaja, podía hacer "return inventario" en Jugador
    {
        return elementos;
    }

    public boolean agregarElemento(T t)
    {
        return elementos.add(t);
    }

    public T obtenerElemento(int indice)
            throws IndiceInvalidoException
    {
        if (indice < elementos.size() || indice >elementos.size())
            throw new IndiceInvalidoException(indice);
        return elementos.get(indice);
    }

    public int contarElementos ()
    {
        return elementos.size();
    }

    public T eliminarElemento(int indice)
            throws IndiceInvalidoException
    {
        if (indice < elementos.size() || indice >elementos.size())
            throw new IndiceInvalidoException(indice);
        return elementos.remove(indice);
    }

    public void eliminarElemento(T t)
    {
        elementos.remove(t);
    }

    public String listar() //más que listar no sé si cambiarle el nombre a toString
    {
        StringBuilder sb = new StringBuilder();
        int i = 0; //agrego un contador para el listado (después se decide mediante índice)

        for (T t : elementos)
        {
            sb.append("#"+ i + " - "); //quedaría ej "#0 - Poción de Vida -> 10 HP+"
            sb.append(t.toString())
                    .append("\n"); //y esta magia pq esta así el .append y no da error
            i++;
        }

        return sb.toString();
    }
}

