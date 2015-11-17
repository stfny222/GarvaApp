package evaldivieso.garvaapp.mvp.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by evaldivieso on 12/10/2015.
 */
@ParseClassName("Dish")
public class ParseDish extends ParseObject{

    public ParseDish() {
    }

    public String getName(){
        return getString("name");
    }

    public String getDesc(){
        return getString("desc");
    }

    public double getPrice(){
        return getDouble("price");
    }

    public double getKcal(){
        return getDouble("kcal");
    }

    public static ParseQuery<ParseDish> getQuery() {
        return ParseQuery.getQuery(ParseDish.class);
    }
}
