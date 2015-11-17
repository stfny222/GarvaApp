package evaldivieso.garvaapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import evaldivieso.garvaapp.mvp.model.ParseDish;
import evaldivieso.garvaapp.mvp.model.ParseSubMenu;
import evaldivieso.garvaapp.mvp.model.ParseMenu;

/**
 * Created by evaldivieso on 16/09/2015.
 */
public class ApplicationController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "fee6KaHuGMHQhZPeog8H74gl01jEc0xAaJUg07pb", "YL7G41Y1xfdNhoDMwO4OyLVGUruGwfWqlXh7xR1k");

        ParseObject.registerSubclass(ParseMenu.class);
        ParseObject.registerSubclass(ParseSubMenu.class);
        ParseObject.registerSubclass(ParseDish.class);
    }
}
