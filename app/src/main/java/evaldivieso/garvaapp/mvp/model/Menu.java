package evaldivieso.garvaapp.mvp.model;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by evaldivieso on 15/10/2015.
 */
public class Menu extends ParseObject {
    String lista;
    List<SubMenu> objetos;

    public Menu() {
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public List<SubMenu> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<SubMenu> objetos) {
        this.objetos = objetos;
    }
}
