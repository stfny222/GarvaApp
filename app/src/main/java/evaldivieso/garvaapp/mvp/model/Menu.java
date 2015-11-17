package evaldivieso.garvaapp.mvp.model;

import java.util.List;

/**
 * Created by evaldivieso on 16/11/2015.
 */
public class Menu {
    String name;
    List<SubMenu> subMenus;

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", subMenus=" + subMenus +
                '}';
    }
}
