package evaldivieso.garvaapp.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import evaldivieso.garvaapp.R;
import evaldivieso.garvaapp.adapter.ListadoAdapter;
import evaldivieso.garvaapp.mvp.model.Dish;
import evaldivieso.garvaapp.mvp.model.Menu;
import evaldivieso.garvaapp.mvp.model.ParseDish;
import evaldivieso.garvaapp.mvp.model.ParseMenu;
import evaldivieso.garvaapp.mvp.model.ParseSubMenu;
import evaldivieso.garvaapp.mvp.model.SubMenu;

public class ListadoActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab_buy)
    FloatingActionButton fab_buy;
    @Bind(R.id.rvListado)
    RecyclerView rvListado;

    ListadoAdapter listadoAdapter;

//    final List<ParseMenu> pmenus = new ArrayList<>();
    final List<Menu> menus = new ArrayList<>();
//    final List<SubMenu> subMenus = new ArrayList<>();
//    final List<Dish> dishes = new ArrayList<>();

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

//        ApplicationController app = (ApplicationController)getApplication();
//        Type listType = new TypeToken<ArrayList<Menu>>() {
//        }.getType();
//        List<Menu> menu = new Gson().fromJson(app.carta, listType);

//        getMenuList();







//        final List<Menu> menus = new ArrayList<>();
//        ParseQuery query1 = ParseMenu.getQuery();
//        query1.findInBackground(new FindCallback<ParseMenu>() {
//            @Override
//            public void done(List<ParseMenu> objects, ParseException e) {
//                Log.e("ListadoActivity", "query1: Menus:" + objects.toString());
//                for (ParseMenu pm : objects) {
//                    Menu menu = new Menu(pm.getName());
//                    Log.e("ListadoActivity", "query1: Menu:" + menu.getName());
//                    final List<SubMenu> subMenus = new ArrayList<SubMenu>();
//                    ParseQuery query2 = ParseSubMenu.getQuery();
//                    query2.whereEqualTo("Menu", pm);
//                    query2.findInBackground(new FindCallback<ParseSubMenu>() {
//                        @Override
//                        public void done(List<ParseSubMenu> objects, ParseException e) {
//                            Log.e("ListadoActivity", "query2: SubMenus:" + objects.toString());
//                            for (ParseSubMenu psm : objects) {
//                                SubMenu subMenu = new SubMenu(psm.getName());
//                                Log.e("ListadoActivity", "query2: SubMenu:" + subMenu.getName());
//                                final List<Dish> dishes = new ArrayList<>();
//                                ParseQuery query3 = ParseDish.getQuery();
//                                query3.whereEqualTo("SubMenu", psm);
//                                query3.findInBackground(new FindCallback<ParseDish>() {
//                                    @Override
//                                    public void done(List<ParseDish> objects, ParseException e) {
//                                        Log.e("ListadoActivity", "query3: Dishes:" + objects.toString());
//                                        for (ParseDish pd : objects) {
//                                            Dish dish = new Dish(pd.getName());
//                                            if (pd.getDesc() != null) {
//                                                dish.setDesc(pd.getDesc());
//                                            }
//                                            if (pd.getPrice() != 0) {
//                                                dish.setPrice(pd.getPrice());
//                                            }
//                                            if (pd.getKcal() != 0) {
//                                                dish.setkCal(pd.getKcal());
//                                            }
//                                            Log.e("ListadoActivity", "query3: Dish: name: " + dish.getName() + "| desc: " + dish.getDesc());
//                                            dishes.add(dish);
//                                        }
//                                    }
//                                });
//                                subMenus.add(subMenu);
//                            }
//                        }
//                    });
//                    menus.add(menu);
//                }
//            }
//        });

        getDishesList();


        fab_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void getDishesList(){
        Log.e("ListadoActivity", "getDishesList");
        ParseQuery<ParseDish> query = ParseDish.getQuery();
        query.include("SubMenu");
        query.include("SubMenu.Menu");
        query.findInBackground(new FindCallback<ParseDish>() {
            @Override
            public void done(List<ParseDish> objects, ParseException e) {
                Log.e("ListadoActivity", "getDishesList done:" + objects.toString());
                for(ParseDish pd : objects){
                    Dish dish = new Dish(pd.getName());
                    if (pd.getDesc() != null) {
                        dish.setDesc(pd.getDesc());
                    }
                    if (pd.getPrice() != 0) {
                        dish.setPrice(pd.getPrice());
                    }
                    if (pd.getKcal() != 0) {
                        dish.setkCal(pd.getKcal());
                    }
                    ParseSubMenu psm = (ParseSubMenu) pd.getParseObject("SubMenu");
                    ParseMenu pm = (ParseMenu) psm.getParseObject("Menu");
                    Log.e("ListadoActivity", "Dish: name: " + dish.getName() + " | desc: " + dish.getDesc());
                    Log.e("ListadoActivity", "SubMenu: " + psm.getName());
                    Log.e("ListadoActivity", "Menu: " + pm.getName());

                    boolean exists = false;
                    for (Menu m : menus){
                        if(m.getName().equalsIgnoreCase(pm.getName())){
                            exists = true;
                            break;
                        }
                    }
                    if(!exists){
                        menus.add(new Menu(pm.getName()));
                    }
                    exists = false;
                    for (Menu m : menus){
                        if(m.getSubMenus()==null){
                            m.setSubMenus(new ArrayList<SubMenu>());
                        }
                        for (SubMenu sm : m.getSubMenus()){
                            if(sm.getName().equalsIgnoreCase(psm.getName())){
                                exists = true;
                                break;
                            }
                        }
                        if(!exists){
                            m.getSubMenus().add(new SubMenu(psm.getName()));
                        }
                    }

                    for(Menu m : menus){
                        if(m.getName().equalsIgnoreCase(pm.getName())){
                            for (SubMenu sm : m.getSubMenus()){
                                if(sm.getName().equalsIgnoreCase(psm.getName())){
                                    if(sm.getDishes()==null){
                                        sm.setDishes(new ArrayList<Dish>());
                                    }
                                    sm.getDishes().add(dish);
                                }
                            }
                        }
                    }
                }
                Log.e("ListadoActivity", "LISTA COMPLETA Menu: " + menus.toString());
                setRecyclerView();
            }
        });
    }

    public void setMenuList(){
    }

//    public void getMenuList(){
//        ParseQuery<ParseMenu> query1 = ParseMenu.getQuery();
//        query1.findInBackground(new FindCallback<ParseMenu>() {
//            @Override
//            public void done(List<ParseMenu> objects, ParseException e) {
//                Log.e("ListadoActivity", "query1: Menus:" + objects.toString());
//                for (ParseMenu pm : objects) {
//                    Log.e("ListadoActivity", "query1: Menu:" + pm.getName());
//                    pmenus.add(pm);
//                    menus.add(new Menu(pm.getName()));
//                }
//                getSubMenuList();
//            }
//        });
//    }
//
//    public void getSubMenuList(){
//        for (int i=0; i<pmenus.size(); i++) {
//            final List<ParseSubMenu> psubMenus = new ArrayList<>();
//            final List<SubMenu> subMenus = new ArrayList<>();
//            ParseQuery query2 = ParseSubMenu.getQuery();
//            query2.whereEqualTo("Menu", pmenus.get(i));
//            query2.findInBackground(new FindCallback<ParseSubMenu>() {
//                @Override
//                public void done(List<ParseSubMenu> objects, ParseException e) {
//                    Log.e("ListadoActivity", "query2: SubMenus:" + objects.toString());
//                    for (ParseSubMenu psm : objects) {
//                        psubMenus.add(psm);
//                        subMenus.add(new SubMenu(psm.getName()));
//                    }
//                }
//            });
//            menus.get(i).setSubMenus(subMenus);
//            for (int j=0; j<psubMenus.size(); j++){
//                Log.e("ListadoActivity", "SubMenu:" + psubMenus.get(i).getName());
//                final List<Dish> dishes = new ArrayList<>();
//                ParseQuery query3 = ParseDish.getQuery();
//                query3.whereEqualTo("SubMenu", psubMenus.get(i));
//                query3.findInBackground(new FindCallback<ParseDish>() {
//                    @Override
//                    public void done(List<ParseDish> objects, ParseException e) {
//                        Log.e("ListadoActivity", "query3: Dishes:" + objects.toString());
//                        for (ParseDish pd : objects) {
//                            Dish dish = new Dish(pd.getName());
//                            if (pd.getDesc() != null) {
//                                dish.setDesc(pd.getDesc());
//                            }
//                            if (pd.getPrice() != 0) {
//                                dish.setPrice(pd.getPrice());
//                            }
//                            if (pd.getKcal() != 0) {
//                                dish.setkCal(pd.getKcal());
//                            }
//                            Log.e("ListadoActivity", "query3: Dish: name: " + dish.getName() + "| desc: " + dish.getDesc());
//                            dishes.add(dish);
//                        }
//                    }
//                });
//                subMenus.get(j).setDishes(dishes);
//            }
//            setRecyclerView();
//        }
//    }

    public void setRecyclerView(){
        listadoAdapter = new ListadoAdapter(ListadoActivity.this, menus);
        rvListado.setAdapter(listadoAdapter);
        rvListado.setLayoutManager(new LinearLayoutManager(this));
    }

}
