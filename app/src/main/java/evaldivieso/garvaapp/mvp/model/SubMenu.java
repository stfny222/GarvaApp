package evaldivieso.garvaapp.mvp.model;

import java.util.List;

/**
 * Created by evaldivieso on 16/11/2015.
 */
public class SubMenu {
    String name;
    List<Dish> dishes;

    public SubMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
