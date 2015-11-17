package evaldivieso.garvaapp.mvp.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by evaldivieso on 15/10/2015.
 */
@ParseClassName("Menu")
public class ParseMenu extends ParseObject {

    public ParseMenu() {
    }

    public String getName(){
        return getString("name");
    }

    public static ParseQuery<ParseMenu> getQuery() {
        return ParseQuery.getQuery(ParseMenu.class);
    }

}
