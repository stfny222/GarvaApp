package evaldivieso.garvaapp.mvp.presenter;

import evaldivieso.garvaapp.mvp.view.LoginView;

public class LoginPresenter implements LoginPresenterIf {
    private static final String url = "http://chorreando.herokuapp.com";

    private LoginView view;

    public LoginPresenter(LoginView view){
        this.view = view;
    }

    @Override
    public void login(String usuario, String password) {
        if((usuario.equals("dtorres") || usuario.equals("evaldivieso")) && password.equals("123")){
            view.onLoginCorrecto();
        }else{
            view.onLoginIncorrecto();
        }
    }
}
