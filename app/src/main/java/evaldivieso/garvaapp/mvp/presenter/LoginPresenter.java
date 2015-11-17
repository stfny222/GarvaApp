package evaldivieso.garvaapp.mvp.presenter;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import evaldivieso.garvaapp.mvp.view.LoginView;

public class LoginPresenter implements LoginPresenterIf {
    private static final String url = "http://chorreando.herokuapp.com";

    private LoginView view;

    public LoginPresenter(LoginView view){
        this.view = view;
    }

    @Override
    public void login(String usuario, String password) {
        ParseUser.logInInBackground(usuario, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    view.onLoginCorrecto(user);
                } else {
                    view.onLoginIncorrecto();
                }
            }
        });
    }
}
