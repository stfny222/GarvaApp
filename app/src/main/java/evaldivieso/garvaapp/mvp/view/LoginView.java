package evaldivieso.garvaapp.mvp.view;

/**
 * Created by hquintana on 12/09/15.
 */
public interface LoginView {
    void onLoginCorrecto();
    void onLoginIncorrecto();
    void onError(String msg);
}
