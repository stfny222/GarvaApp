package evaldivieso.garvaapp.mvp.view;

import com.parse.ParseUser;

/**
 * Created by hquintana on 12/09/15.
 */
public interface LoginView {
    void onLoginCorrecto(ParseUser user);
    void onLoginIncorrecto();
}
