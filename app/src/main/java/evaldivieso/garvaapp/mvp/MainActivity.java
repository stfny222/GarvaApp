//Totally #Homo
            /*
            Si esto sale en github tendre problemas
             */
package evaldivieso.garvaapp.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import evaldivieso.garvaapp.ApplicationController;
import evaldivieso.garvaapp.R;
import evaldivieso.garvaapp.mvp.presenter.LoginPresenter;
import evaldivieso.garvaapp.mvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.tvInvitado)
    TextView tvInvitado;
    @Bind(R.id.tvRegistrar)
    TextView tvRegistrar;
    @Bind(R.id.etUsername)
    EditText etUsername;
    @Bind(R.id.etPassword)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        btnLogin.setOnClickListener(this);
        tvRegistrar.setOnClickListener(this);
        tvInvitado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            new LoginPresenter(this).login(username, password);

        }else if (v.getId() == R.id.tvRegistrar){
            Log.i("MainActivity", "Se hizo click en el botón Registrar");
            Toast.makeText(
                    this,
                    "Llamar al caso de uso \"Registrar\"",
                    Toast.LENGTH_LONG
            ).show();
        }else{
            Log.i("MainActivity", "Se hizo click en el botón Ingresar cmo invitado");
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ListadoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onLoginCorrecto(ParseUser user) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ListadoActivity.class);
        intent.putExtra("username", user.getString("name"));
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginIncorrecto() {
        Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
    }

}
