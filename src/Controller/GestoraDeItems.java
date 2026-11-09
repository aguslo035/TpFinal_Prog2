package Controller;

import Interface.IItem;

import java.util.ArrayList;
import java.util.List;

public class GestoraDeItems {
    private List<IItem> elementos;

    public GestoraDeItems() {
        elementos = new ArrayList<>();
    }

    public void agregar(IItem o)
    {
        elementos.add(o);
    }

    public IItem obtener(int indice)
    {
        return elementos.get(indice);
    }

    public void eliminar(int indice)
    {
        elementos.remove(indice);
    }

    public String listar()
    {
        StringBuilder sb = new StringBuilder();
        int i = 0; //agrego un contador para el listado (después se decide mediante índice)

        for (IItem e : elementos)
        {
            sb.append("#"+ i + " - "); //quedaría ej "#0 - Poción de Vida -> 10 HP+"
            sb.append(e.toString())
                    .append("\n"); //y esta magia pq esta así el .append y no da error
            i++;
        }

        return sb.toString();
    }
}

