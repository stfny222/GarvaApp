package evaldivieso.garvaapp.mvp.model;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by evaldivieso on 15/10/2015.
 */
public class SubMenu extends ParseObject {
    String tipo;
    List<Dish> dishs;

    public SubMenu() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }
}
