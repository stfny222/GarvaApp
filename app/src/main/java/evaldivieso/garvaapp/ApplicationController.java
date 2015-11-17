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
    public String carta;
    public String username;

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "fee6KaHuGMHQhZPeog8H74gl01jEc0xAaJUg07pb", "YL7G41Y1xfdNhoDMwO4OyLVGUruGwfWqlXh7xR1k");

        ParseObject.registerSubclass(ParseMenu.class);
        ParseObject.registerSubclass(ParseSubMenu.class);
        ParseObject.registerSubclass(ParseDish.class);



























        username = "";
        carta = "[\n" +
                "  {\n" +
                "    \"lista\": \"LA CARTA DEL CHÉ\",\n" +
                "    \"objetos\":\n" +
                "    [\n" +
                "    {\n" +
                "    \"tipo\": \"HAMBURGUESAS\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"HAMBURGUESA DE CARNE\",\n" +
                "        \"descripcion\": \"Deliciosa hamburguesa casera acompañada de lechuga, tomate y papitas al hilo servida en un pan enorme.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"HAMBURGUESA DE POLLO\",\n" +
                "        \"descripcion\": \"Hamburguesa de pollo empanizada acompañada de lechuga, tomate y abundantes papitas al hilo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"CHEESE BURGUER\",\n" +
                "        \"descripcion\": \"Nuestra deliciosa hamburguesa casera con tomate, lechuga, papitas al hijo y una tajada de queso dambo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"HAMBURGUESA ROYAL\",\n" +
                "        \"descripcion\": \"Deliciosa hamburguesa casera con huevo frito y queso. Además de tomate, lechuga y abundantes papitas al hilo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"HAMBURGUESA AL PLATO\",\n" +
                "        \"descripcion\": \"Nuestra clásica hamburguesa en una canasta con abundantes papas fritas y ensalada fresca.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"BACON AL PLATO\",\n" +
                "        \"descripcion\": \"Hamburguesa de res, delicioso tocino ahumado y queso. Servida con papas fritas y ensalada fresca.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"VEGGIE BURGUER\",\n" +
                "        \"descripcion\": \"Una opción diferente, carne de soya a la plancha en pan de hamburguesa, lechuga, tomate y papitas al hilo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"tipo\": \"SALCHIPAPAS\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"SALCHIPAPA CLÁSICA\",\n" +
                "        \"descripcion\": \"Crocantes papas fritas con salchicha frankfurter.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"CHORI PAPAS\",\n" +
                "        \"descripcion\": \"Una porción de papas fritas recién hechas acompañadas de chorizo parrillero.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"SALCHI CLUB\",\n" +
                "        \"descripcion\": \"Abundantes papas fritas con salchicha frankfurter, huevo frito a la inglesa, chorizo parrillero y 3 nuggets de pollo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "{\n" +
                "    \"tipo\": \"A LA PLANCHA\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"MIXTO SIMPLE\",\n" +
                "        \"descripcion\": \"Tres tajadas de pan de molde blanco tostado en mantequilla con jamón inglés y queso dambo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"MIXTO COMPLETO\",\n" +
                "        \"descripcion\": \"Cuatro tajadas de pan de molde blanco tostado en mantequilla, jamón inglés, queso dambo y juevo frito.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"POLLO DESHILACHADO\",\n" +
                "        \"descripcion\": \"El de siempre. Pollo deshilachado con papitas al hilo en pan hamburguesa. Disfrútalo con tus cremas favoritas.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"COMBO DE HOT DOG JR.\",\n" +
                "        \"descripcion\": \"Salchicha vienesa en pan hot dog con papas fritas y además un vaso de refresco de naranja. ¡Listo al instante!.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"CLUB SANDWICH\",\n" +
                "        \"descripcion\": \"El preferido de todos. Cuatro piezas de pan de molde blanco, tocino ahumado, huevo, jamón inglés, queso dambo, pollo deshilachado, tomate y crocantes papas fritas.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"LOMITO DE RES\",\n" +
                "        \"descripcion\": \"120 gramos de bisteck de res marinado en salsa inglesa sobre una cama de palta y queso. Servido en pan ciabatta crocante y con papas fritas. ¡Simplemente delicioso!.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"LOMITO AHUMADO CRIOLLO\",\n" +
                "        \"descripcion\": \"Otro gigante. Abundante lomito ahumado con zarza criolla en pan ciabatta y con papas fritas.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "{\n" +
                "    \"tipo\": \"CROCANTES\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"ALITAS BROASTER\",\n" +
                "        \"descripcion\": \"Seis crocantes alitas fritas acompañadas de papas fritas y ensalada fresca.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"POLLO CRISPY\",\n" +
                "        \"descripcion\": \"Filete de pollo empanizado en pan hamburguesa. Acompañado de queso, tomate y crocantes papitas al hilo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"POLLO CRISPY COMPLETO\",\n" +
                "        \"descripcion\": \"Al delicioso pollo crispy le agregamos el mejor complemento: queso dambo y tocino ahumado.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "      ,\n" +
                "      {\n" +
                "        \"nombre\": \"TEQUEÑOS\",\n" +
                "        \"descripcion\": \"Seis unidades de crocante masa wantán rellena de jamón y queso fundido.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "{\n" +
                "    \"tipo\": \"BEBIDAS Y ENSALADAS\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"ENSALADA DE FRUTAS\",\n" +
                "        \"descripcion\": \"Frescas y dulces frutas de estación como piña, papaya, melón, sandía. Con miel de abeja, algarrobina y yogurt natural.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO ESPECIAL\",\n" +
                "        \"descripcion\": \"Papaya, piña, leche y algarrobina.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO SURTIDO\",\n" +
                "        \"descripcion\": \"Papaya, plátano, piña y beterraga.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO DE NARANJA\",\n" +
                "        \"descripcion\": \"Exprimido al momento.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO DE PAPAYA\",\n" +
                "        \"descripcion\": \"\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO DE PIÑA\",\n" +
                "        \"descripcion\": \"\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO DE PLÁTANO CON LECHE\",\n" +
                "        \"descripcion\": \"\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO DE FRESA\",\n" +
                "        \"descripcion\": \"*Fruta de estación. Consultar disponibilidad\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"JUGO DE FRESA CON LECHE\",\n" +
                "        \"descripcion\": \"*Fruta de estación. Consultar disponibilidad\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"CREMOLADAS\",\n" +
                "        \"descripcion\": \"De frutas naturales.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  }]\n" +
                "  },\n" +
                "  {\n" +
                "    \"lista\": \"ESPECIALES DEL CHÉ\",\n" +
                "    \"objetos\": [{\n" +
                "    \"tipo\": \"PLATOS A LA PLANCHA\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"BISTEC A LO POBRE\",\n" +
                "        \"descripcion\": \"Jugoso bisteck a la plancha acompañado de arroz, papas, plátano y huevo frito a la inglesa. ¡Para un hambre de náufrago!.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"CHULETA A LA PARRILLA\",\n" +
                "        \"descripcion\": \"¿Tienes hambre? Deliciosa chuleta de cerdo de 250 gr. aderezada. Acompañada con papas fritas, ensalada o arroz.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"MILANESA DE POLLO\",\n" +
                "        \"descripcion\": \"Pechuga de pollo empanizada y a la plancha. Acompáñala con papas y arroz, papas y ensalada o como tú prefieras.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"SUPREMA DE POLLO\",\n" +
                "        \"descripcion\": \"Filete de pierna de pollo empanizado. Puedes acompañarlo con papas y arroz, ensalada y papas o como tú prefieras.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"FILETE DE POLLO\",\n" +
                "        \"descripcion\": \"Filete de pechuga a la plancha o al vapor si lo tuyo es lo light. Con papas y ensalada, papas y arroz o solo ensalada.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"BISTEC A LA PLANCHA\",\n" +
                "        \"descripcion\": \"Acompáñalo de papas fritas y arroz, arroz y ensalada, ensalada y papas o como tú prefieras. Pruébalo también apanado.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"MILANESA DE SOYA\",\n" +
                "        \"descripcion\": \"Carne de soya empanizada al igual que una de pollo. Acompáñala con papas y ensalada, solo ensalada o como quieras.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"HAMBURGUESA A LO POBRE\",\n" +
                "        \"descripcion\": \"Hamburguesa de la casa servida con arroz, papas fritas, huevo frito, plátano frito.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"ARROZ A LA CUBANA\",\n" +
                "        \"descripcion\": \"Básico y delicioso. Arroz acompañado de plátano frito, crocantes papas y dos huevos montados.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"tipo\": \"SALTADOS\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"LOMO SALTADO\",\n" +
                "        \"descripcion\": \"¡El favorito de todos! Carne de res saltada con cebolla, tomate y su toque de ají. Viene con papas fritas y arroz.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"POLLO SALTADO\",\n" +
                "        \"descripcion\": \"Trozos de pollo saltados con cebolla, tomate y su toque de ají amarillo. Acompañado con papas fritas y arroz.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"ARROZ CHAUFA\",\n" +
                "        \"descripcion\": \"¡Otro de tus favoritos! Arroz saltado con pollo o res y con el inconfundible toque oriental.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"TALLARÍN SALTADO\",\n" +
                "        \"descripcion\": \"Criollísima combinación de pasta y lomo saltado.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"VERDURAS SALTADAS CON TOFU\",\n" +
                "        \"descripcion\": \"Una opción distinta y deliciosa. Saltado de verduras del día con tofu en lugar de carne. Servido con papas y arroz.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"tipo\": \"PASTAS\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"RAVIOLES A LA BOLOGNESA\",\n" +
                "        \"descripcion\": \"Rellenos con carne y por fuera abundante salsa bolognesa y su toque de queso parmesano.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"LASAGNA DE CARNE\",\n" +
                "        \"descripcion\": \"¡La favorita del menú ahora en la carta y más grande! Pastel de fideo al horno con salsa blanca y bolognesa y abundante queso.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"LASAGNA DE RICOTTA Y VEGETALES\",\n" +
                "        \"descripcion\": \"Lasagna con salsa blanca y roja. Con queso ricotta, espinacas y vegetales de estación.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"tipo\": \"ENSALADAS\",\n" +
                "    \"platos\": [\n" +
                "      {\n" +
                "        \"nombre\": \"ENSALADA DE ATÚN\",\n" +
                "        \"descripcion\": \"Fresco mix de lechugas, tomate, huevo duro, aceitunas verdes, cebolla blanca, brócoli, palta y atún en conserva. Servida con una riquísima vinagreta al olivo.\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"ENSALADA A LA HUANCAÍNA\",\n" +
                "        \"descripcion\": \"Fresco mix de lechugas con pepino, zanahoria, choclo, queso fresco, papa sancochada, jamón y pollo deshilachado. Servida con un delicioso aliño de crema huancaína\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      },\n" +
                "      {\n" +
                "        \"nombre\": \"ENSALADA DE FRUTAS\",\n" +
                "        \"descripcion\": \"Frescas y dulces frutas de estación como: piña, papaya, melón, sandía. Bañadas con miel de abeja, algarrobina, yogurt natural y hojuelas de maiz\",\n" +
                "        \"precio\": \"S/. \",\n" +
                "        \"kcal\": \"KCAL \"\n" +
                "      }\n" +
                "    ]\n" +
                "  }]\n" +
                "  }\n" +
                "]";
    }
}
