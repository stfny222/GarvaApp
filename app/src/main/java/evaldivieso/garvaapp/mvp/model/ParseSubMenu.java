package evaldivieso.garvaapp.mvp.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by evaldivieso on 15/10/2015.
 */
@ParseClassName("SubMenu")
public class ParseSubMenu extends ParseObject {

    public ParseSubMenu() {
    }

    public String getName(){
        return getString("name");
    }

    public static ParseQuery<ParseSubMenu> getQuery() {
        return ParseQuery.getQuery(ParseSubMenu.class);
    }
}
