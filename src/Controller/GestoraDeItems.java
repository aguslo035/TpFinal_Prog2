package Controller;

import Exception.Juego.IndiceInvalidoException;
import Interface.IItem;

import java.util.ArrayList;
import java.util.List;

public class GestoraDeItems<T extends IItem> {
    /* Al hacer que la gestora de items sea generica a partir de IItem, se puede utilizar para asegurar un futuro manejo de otros tipos de items.
    Como por ejemplo, un cofre específico de pociones, o una tienda de armas*/

    //atributos
    private List<T> elementos;

    //constructor
    public GestoraDeItems() {
        elementos = new ArrayList<>();
    }

    //getters y setters
    public List<T> getElementos ()
    {
        return elementos;
    }

    public void setElementos(List<T> elementos) {
        this.elementos = elementos;
    }

    //metodos
    public boolean agregarElemento(T t)
    {
        return elementos.add(t);
    }

    public T obtenerElemento(int indice)
            throws IndiceInvalidoException
    {
        if (indice < 0 || indice >= elementos.size())
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
        if (indice < 0 || indice >= elementos.size())
            throw new IndiceInvalidoException(indice);
        return elementos.remove(indice);
    }

    public void eliminarElemento(T t)
    {
        elementos.remove(t);
    }

    //Lista los elementos del gestor de forma linda.
    public String listar()
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

    //A partir del item que se le entregue, devuelve texto indicandole al usuario que se agregó ese item.
    public String textoDeAgregado (T itemAgregado)
    {
        return "Se ha agregado "+ itemAgregado.getClass() + " a su inventario.";
    }
}

