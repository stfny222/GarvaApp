package evaldivieso.garvaapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import evaldivieso.garvaapp.mvp.model.Dish;
import evaldivieso.garvaapp.mvp.model.Menu;
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

    public ListadoAdapter(Context context, List<Menu> menus) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        updateData(menus);
    }

    public void updateData(List<Menu> menus) {
        this.data.clear();
        DataRequired dr;
        for (Menu m : menus) {
            dr = new DataRequired(HEADER_TYPE);
            dr.setName(m.getName());
            data.add(dr);
            for (SubMenu sc : m.getSubMenus()) {
                dr = new DataRequired(SHEADER_TYPE);
                dr.setName(sc.getName());
                data.add(dr);
                if(sc.getDishes()==null){
                    sc.setDishes(new ArrayList<Dish>());
                }
                for (Dish d : sc.getDishes()) {
                    dr = new DataRequired(ITEM_TYPE);
                    dr.setDish(d);
                    data.add(dr);
                }
            }
        }
        Log.e("ListadoAdapter", data.toString());
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
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
        if (current.getType() == HEADER_TYPE) {
            holder.tv_nombre.setText(current.getName());
        } else if (current.getType() == SHEADER_TYPE) {
            holder.tv_nombre.setText(current.getName());
        } else {
            holder.tv_nombre.setText(current.getDish().getName().toUpperCase());
            if(holder.tv_desc!=null){
                holder.tv_desc.setText(current.getDish().getDesc());
            }
            holder.tv_precio.setText("S/. " + Double.toString(current.getDish().getPrice()));
            holder.tv_kcal.setText(Double.toString(current.getDish().getkCal()) + " kCal");
//            if (current.isChecked()) {
//                holder.wrapper.setBackgroundResource(R.color.selected_item);
//            } else {
//                holder.wrapper.setBackgroundResource(R.color.item);
//            }
//            holder.itemView.setOnClickListener(this);
//            holder.itemView.setOnLongClickListener(this);
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
                    monto = monto.add(new BigDecimal(item.getDish().getPrice()));
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
//        @Bind(R.id.wrapper)
//        LinearLayout wrapper;
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
        int type;
        Dish dish;
        String name;
        Double kcal;
        Double price;
        Boolean checked;

        public DataRequired(int type) {
            this.type = type;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getKcal() {
            return kcal;
        }

        public void setKcal(Double kcal) {
            this.kcal = kcal;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Boolean getChecked() {
            return checked;
        }

        @Override
        public String toString() {
            return "DataRequired{" +
                    "type=" + type +
                    ", dish=" + dish +
                    ", name='" + name + '\'' +
                    ", kcal=" + kcal +
                    ", price=" + price +
                    ", checked=" + checked +
                    '}';
        }
    }

}
