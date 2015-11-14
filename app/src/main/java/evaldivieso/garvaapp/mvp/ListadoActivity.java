package evaldivieso.garvaapp.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import evaldivieso.garvaapp.ApplicationController;
import evaldivieso.garvaapp.R;
import evaldivieso.garvaapp.adapter.ListadoAdapter;
import evaldivieso.garvaapp.mvp.model.Menu;

public class ListadoActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab_buy)
    FloatingActionButton fab_buy;
    @Bind(R.id.rvListado)
    RecyclerView rvListado;

    ListadoAdapter listadoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        /*
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        */

        ApplicationController app = (ApplicationController)getApplication();
        Type listType = new TypeToken<ArrayList<Menu>>() {
        }.getType();
        List<Menu> menu = new Gson().fromJson(app.carta, listType);

        listadoAdapter = new ListadoAdapter(ListadoActivity.this, menu);
        rvListado.setAdapter(listadoAdapter);
        rvListado.setLayoutManager(new LinearLayoutManager(this));

        fab_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
