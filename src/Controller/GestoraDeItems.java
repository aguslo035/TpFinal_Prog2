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

        for (IItem e : elementos)
        {
            sb.append(e.toString())
                    .append("\n");
        }

        return sb.toString();
    }
}

