package evaldivieso.garvaapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import evaldivieso.garvaapp.R;
import evaldivieso.garvaapp.mvp.model.Menu;
import evaldivieso.garvaapp.mvp.model.Dish;
import evaldivieso.garvaapp.mvp.model.SubMenu;

/**
 * Created by evaldivieso on 15/09/2015.
 */
public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.ListadoViewHolder> implements View.OnClickListener, View.OnLongClickListener{
    private static final int HEADER_TYPE = 0;
    private static final int SHEADER_TYPE = 1;
    private static final int ITEM_TYPE = 2;
    private LayoutInflater inflater;
    List<DataRequired> data;
    private OnSelectItemsListener listener;

    public ListadoAdapter(Context context, List<Menu> menu) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        updateData(menu);
    }

    public void updateData(List<Menu> menu) {
        this.data.clear();
        DataRequired dr;
        for (Menu c : menu) {
            dr = new DataRequired(HEADER_TYPE);
            dr.setTitle(c.getLista());
            data.add(dr);
            for (SubMenu sc : c.getObjetos()) {
                dr = new DataRequired(SHEADER_TYPE);
                dr.setTitle(sc.getTipo());
                data.add(dr);
                for (Dish p : sc.getDishs()) {
                    dr = new DataRequired(ITEM_TYPE);
                    dr.setDish(p);
                    data.add(dr);
                }
            }
        }

        /*Collections.sort(platos, Plato.PlatoComparator);
        List<String> subheaders = new ArrayList<>();
        boolean repetido=false;
        for(Plato p1 : platos){
            for (String sh : subheaders) {
                if(sh.equalsIgnoreCase(p1.getTipo())){
                    repetido = true;
                    break;
                }
            }
            if(!repetido){
                DataRequired d = new DataRequired(HEADER_TYPE);
                d.setTitle(p1.getTipo());
                data.add(d);
                subheaders.add(p1.getTipo());
            }
            DataRequired d = new DataRequired(ITEM_TYPE);
            d.setPlato(p1);
            data.add(d);
        }*/

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getTipo();
    }

    @Override
    public ListadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == HEADER_TYPE) {
            view = inflater.inflate(R.layout.header_listado, parent, false);
        } else if (viewType == SHEADER_TYPE) {
            view = inflater.inflate(R.layout.sheader_listado, parent, false);
        } else {
            view = inflater.inflate(R.layout.item_listado, parent, false);
        }
        return new ListadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListadoViewHolder holder, int position) {
        DataRequired current = data.get(position);
        if (current.getTipo() == HEADER_TYPE) {
            holder.tv_nombre.setText(current.getTitle());
        } else if (current.getTipo() == SHEADER_TYPE) {
            holder.tv_nombre.setText(current.getTitle());
        } else {
            holder.tv_nombre.setText(current.getDish().getNombre().toUpperCase());
            holder.tv_desc.setText(current.getDish().getDescripcion());
            holder.tv_precio.setText(current.getDish().getPrecio());
            holder.tv_kcal.setText(current.getDish().getKcal());
            if (current.isChecked()) {
                holder.wrapper.setBackgroundResource(R.color.selected_item);
            } else {
                holder.wrapper.setBackgroundResource(R.color.item);
            }
            holder.itemView.setOnClickListener(this);
            holder.itemView.setOnLongClickListener(this);
            holder.itemView.setTag(current);
        }
    }

    @Override
    public void onClick(View v) {
        if (getItemsSelected().size() > 0) {
            selectItem((DataRequired) v.getTag());
        } else {
            listener.showMessage("Mantener presionado para seleccionar");
        }
    }

    @Override
    public boolean onLongClick(View v) {
        listener.onStartActionMode();
        if (getItemsSelected().size() > 0) {
            onClick(v);
        } else {
            selectItem((DataRequired) v.getTag());
        }
        return true;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void selectItem(DataRequired item) {
        boolean checked = item.isChecked();
        if (getItemsSelected().size() == 0) {
            listener.onFinishPaymentActionMode();
        }
        listener.onUpdatePaymentAmount(getAmount());
        notifyDataSetChanged();
    }

    public List<DataRequired> getItemsSelected() {
        List<DataRequired> list = new ArrayList<>();
        for (DataRequired item : data) {
            if (item.isChecked()) {
                list.add(item);
            }
        }
        return list;
    }

    public String getAmount() {
        BigDecimal monto = new BigDecimal("0");
        for (DataRequired item : data) {
                if (item.isChecked()) {
                    monto = monto.add(new BigDecimal(item.getDish().getPrecio()));
                }
        }
        return "S/. " + String.format(Locale.ENGLISH, "%.2f", Double.parseDouble(monto.toString()));
    }

    public void setOnSelectItemsListener(OnSelectItemsListener listener) {
        this.listener = listener;
    }

    public interface OnSelectItemsListener {

        void onUpdatePaymentAmount(String amount);

        void onStartActionMode();

        void onFinishPaymentActionMode();

        void showMessage(String message);

    }

    class ListadoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.wrapper)
        LinearLayout wrapper;
        @Bind(R.id.tv_nombre)
        TextView tv_nombre;
        @Nullable
        @Bind(R.id.tv_desc)
        TextView tv_desc;
        @Nullable
        @Bind(R.id.tv_precio)
        TextView tv_precio;
        @Nullable
        @Bind(R.id.tv_kcal)
        TextView tv_kcal;

        public ListadoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DataRequired {
        int tipo;
        Dish dish;
        String title;
        String kcal;
        String precio;
        Boolean checked;

        public DataRequired(int tipo) {
            this.tipo = tipo;
        }

        public Boolean isChecked() {
            return checked;
        }

        public void setChecked(Boolean checked) {
            this.checked = checked;
        }

        public Dish getDish() {
            return dish;
        }

        public void setDish(Dish dish) {
            this.dish = dish;
        }

        public int getTipo() {
            return tipo;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKcal() {
            return kcal;
        }

        public void setKcal(String kcal) {
            this.kcal = kcal;
        }

        public String getPrecio() {
            return precio;
        }

        public void setPrecio(String precio) {
            this.precio = precio;
        }

        public Boolean getChecked() {
            return checked;
        }
    }

}
