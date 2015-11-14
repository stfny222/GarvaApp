package evaldivieso.garvaapp.mvp.model;

import com.parse.ParseObject;

import java.util.Comparator;

/**
 * Created by evaldivieso on 12/10/2015.
 */
public class Dish extends ParseObject{
    String nombre;
    String descripcion;
    //String tipo;
    String precio;
    String kcal;
    boolean checked;

    public Dish() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    */

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /*
    public static Comparator<Plato> PlatoComparator = new Comparator<Plato>() {

        public int compare(Plato s1, Plato s2) {
            String tipo1 = s1.getTipo().toUpperCase();
            String tipo2 = s2.getTipo().toUpperCase();

            //ascending order
            return tipo1.compareTo(tipo2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};
    */
}
