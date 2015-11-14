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
        /*LoginRequest loginRequest = new LoginRequest(usuario, password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginService service = retrofit.create(LoginService.class );

        service.login(loginRequest).enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Response<GenericResponse> response) {
                if (response.body().getMsgStatus().equals("OK")) {
                    view.onLoginCorrecto();
                } else if (response.body().getMsgStatus().equals("ERROR")) {
                    view.onLoginIncorrecto();
                } else {
                    view.onError(response.body().getMsgError());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                view.onError("LoginPresenter (5XX): " + t.getMessage());
            }
        });*/
        if(usuario.equals("holi") && password.equals("boli")){
            view.onLoginCorrecto();
        }else{
            view.onLoginIncorrecto();
        }
    }
}
