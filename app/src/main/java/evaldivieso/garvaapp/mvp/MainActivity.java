//Totally #Homo
            /*
            Si esto sale en github tendre problemas
             */
package evaldivieso.garvaapp.mvp;

import android.content.Intent;
import android.os.Bundle;
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

//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();
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
                    "Opcion de Registrar... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }else{
            Log.i("MainActivity", "Se hizo click en el botón Ingresar cmo invitado");
            Toast.makeText(
                    this,
                    "Opcion de Registrarse... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    @Override
    public void onLoginCorrecto() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,
                ListadoActivity.class);
        //intent.putExtra("username", etUsername.getText().toString());
        ((ApplicationController) getApplication()).username = etUsername.getText().toString();
        startActivity(intent);
    }

    @Override
    public void onLoginIncorrecto() {
        Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, "Error :(", Toast.LENGTH_SHORT).show();
    }
}
